package com.exchanger.controller;

import com.exchanger.dto.ConfirmTransactionRequest;
import com.exchanger.dto.TransactionRequest;
import com.exchanger.dto.UserRequest;
import com.exchanger.dto.UserResponse;
import com.exchanger.service.TransferService;
import com.exchanger.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallets/")
@RequiredArgsConstructor
@Slf4j
public class WalletController {

    private final TransferService transferService;

    @PostMapping("/put")
    public UUID putMoney(@RequestBody TransactionRequest request) {
        return transferService.putMoney(request);
    }

    @PostMapping("/transfer")
    public UUID trnsfMoney(@RequestBody TransactionRequest request) {
        return transferService.transferMoney(request);
    }

    @PostMapping("/transfer/approve")
    public void transferApprove(@RequestBody ConfirmTransactionRequest transferDto) {
        transferService.confirmTransfer(transferDto);
    }

}
