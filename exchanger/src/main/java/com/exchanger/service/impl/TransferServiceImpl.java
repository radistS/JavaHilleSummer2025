package com.exchanger.service.impl;

import com.exchanger.dto.ConfirmTransactionRequest;
import com.exchanger.dto.ExcangeRequest;
import com.exchanger.dto.TransactionRequest;
import com.exchanger.entity.TransactionEntity;
import com.exchanger.entity.UserEntity;
import com.exchanger.entity.WalletEntity;
import com.exchanger.entity.enums.CurrencyEnum;
import com.exchanger.entity.enums.TransactionStatus;
import com.exchanger.entity.enums.TransactionType;
import com.exchanger.exceptions.NotEnoughtMoneyException;
import com.exchanger.exceptions.TransactionNotFoundException;
import com.exchanger.exceptions.WalletNotFoundException;
import com.exchanger.repository.TransactionRepository;
import com.exchanger.repository.WalletRepository;
import com.exchanger.service.CacheService;
import com.exchanger.service.TransferService;
import com.exchanger.service.UserService;
import com.exchanger.telegram.TelegramBot;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {

    private final UserService userService;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final TelegramBot telegramBot;
    private final CacheService cacheService;


    @Override
    public UUID putMoney(TransactionRequest request) {
        UserEntity user = userService.findByPhone(request.getFromPhone());

        WalletEntity wallet = walletRepository.findAllByUserAndCurrency(
            user, request.getCurrency()).orElseThrow(WalletNotFoundException::new);

        wallet.setBalance(wallet.getBalance().add(request.getAmount()));
        walletRepository.save(wallet);

        return transactionRepository.save(new TransactionEntity()
            .setType(TransactionType.PUT)
            .setStatus(TransactionStatus.EXECUTED)
            .setReceiver(user.getPhone())
            .setAmountTo(request.getAmount())
            .setCurrencyTo(request.getCurrency())
            .setUpdateAt(LocalDateTime.now())
        ).getId();
    }

    @Override
    public UUID getMoney(TransactionRequest request) {
        return null;
    }

    @Override
    public UUID exchangeMoney(ExcangeRequest request) {



        return null;
    }

    @Override
    public UUID transferMoney(TransactionRequest request) {
        UserEntity from = userService.findByPhone(request.getFromPhone());
        balanceValidation(from, request.getCurrency(), request.getAmount(), TransactionType.TRANSF);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setSender(request.getFromPhone());
        transaction.setCurrencyFrom(request.getCurrency());
        transaction.setAmountFrom(request.getAmount());

        transaction.setReceiver(request.getToPhone());
        transaction.setCurrencyTo(request.getCurrency());
        transaction.setAmountTo(request.getAmount());

        transaction.setType(TransactionType.TRANSF);
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setUpdateAt(LocalDateTime.now());

        String code = RandomStringUtils.randomAlphabetic(6);
        transaction.setCode(code);

        cacheService.addValueToCache(request.getFromPhone() ,code);

        transactionRepository.save(transaction);

        telegramBot.sendMessage(from.getTelegramChatId(), code);

        return transaction.getId();
    }

    private void balanceValidation(UserEntity from, CurrencyEnum currency, BigDecimal amount, TransactionType type) {
        Optional<WalletEntity> walletOption = walletRepository.findAllByUserAndCurrency(from,
            currency);

        if (walletOption.isEmpty()) {
            throw new WalletNotFoundException();
        }
        WalletEntity wallet = walletOption.get();
        BigDecimal balance = wallet.getBalance();

        if (balance.compareTo(amount) < 1) {

            TransactionEntity transaction = new TransactionEntity();
            transaction.setType(type);
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setReceiver(from.getPhone());
            transaction.setAmountTo(amount);
            transaction.setCurrencyTo(currency);
            transactionRepository.save(transaction);

            throw new NotEnoughtMoneyException();
        }
    }

    @Override
    public void confirmTransfer(ConfirmTransactionRequest request) {
        UserEntity from = userService.findByPhone(request.getPhone());

        Optional<TransactionEntity> transaction =
            transactionRepository.findTransactionByIdAndSender(request.getTransactionId(), request.getPhone());

        if (transaction.isEmpty()) {
            throw new TransactionNotFoundException();
        }

        TransactionEntity tran = transaction.get();

        // validate amount
        balanceValidation(from, tran.getCurrencyFrom(), tran.getAmountFrom(), TransactionType.TRANSF);

        String otpCode = cacheService.getValueFromCache(request.getPhone());

        if (!request.getCode().equals(otpCode)){
            tran.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(tran);

            throw new TransactionNotFoundException();
        }

        WalletEntity wFrom = walletRepository.findAllByUserAndCurrency(from, tran.getCurrencyFrom())
            .orElseThrow(WalletNotFoundException::new);
        WalletEntity wTo = walletRepository.findAllByUserAndCurrency(userService.findByPhone(tran.getReceiver()), tran.getCurrencyTo())
            .orElseThrow(WalletNotFoundException::new);
//        Wallet systemWallet = walletRepository.findAllByUserAndCurrency(
//                userRepository.findById(10L).orElseThrow(() -> new UserNotFoundException("System user not found"))
//                , tran.getCurrencyTo())
//            .orElseThrow(() -> new WalletNotFoundException());
//
//        BigDecimal fee = calculateFee(tran.getAmountFrom());

        wFrom.setBalance(wFrom.getBalance().subtract(tran.getAmountFrom()));
        wTo.setBalance(wTo.getBalance().add(tran.getAmountFrom()));
//            .subtract(fee));
//        systemWallet.setBalance(systemWallet.getBalance().add(fee));


        walletRepository.save(wFrom);
        walletRepository.save(wTo);
//        walletRepository.save(systemWallet);

        tran.setStatus(TransactionStatus.EXECUTED);
        tran.setCode(null);
        tran.setUpdateAt(LocalDateTime.now());
        transactionRepository.save(tran);

    }
}
