package com.exchanger.service;

import com.exchanger.dto.ConfirmTransactionRequest;
import com.exchanger.dto.ExcangeRequest;
import com.exchanger.dto.TransactionRequest;
import java.util.UUID;

public interface TransferService {
    UUID putMoney(TransactionRequest request);
    UUID getMoney(TransactionRequest request);
    UUID exchangeMoney(ExcangeRequest request);
    UUID transferMoney(TransactionRequest request);
    void confirmTransfer(ConfirmTransactionRequest request);

}
