package com.exchanger.entity;

import com.exchanger.entity.enums.CurrencyEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "rate")
public class RateEntity extends BaseEntity {

    private CurrencyEnum currency;
    private String sale;
    private String buy;
    private Timestamp receive;

}
