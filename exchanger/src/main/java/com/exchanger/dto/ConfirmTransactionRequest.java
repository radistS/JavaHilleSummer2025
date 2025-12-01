package com.exchanger.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ConfirmTransactionRequest {
    private UUID transactionId;
    private String phone;
    private String code;

}
