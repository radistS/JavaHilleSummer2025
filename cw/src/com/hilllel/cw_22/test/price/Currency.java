package com.hilllel.cw_22.test.price;

import java.math.BigDecimal;

public enum Currency {

    USD, EUR, UAH;

    public static class Price {
        public BigDecimal price;
        public Currency currency;
    }
}
