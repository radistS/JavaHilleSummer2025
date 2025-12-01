package com.exchanger.dto;

import com.exchanger.entity.enums.CurrencyEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TransactionRequest {
    private String fromPhone;
    private String toPhone;
    private BigDecimal amount;
    private CurrencyEnum currency;


}
