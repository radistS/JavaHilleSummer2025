package com.exchanger.dto;

import com.exchanger.entity.enums.CurrencyEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ExcangeRequest {
    private String phone;
    private BigDecimal amount;
    private CurrencyEnum currencyFrom;
    private CurrencyEnum currencyTo;


}
