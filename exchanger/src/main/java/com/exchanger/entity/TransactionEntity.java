package com.exchanger.entity;

import com.exchanger.entity.enums.CurrencyEnum;
import com.exchanger.entity.enums.TransactionStatus;
import com.exchanger.entity.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;


@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "type_trans")
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "status")
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private TransactionStatus status;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "c_from", columnDefinition = "currency")
//    @JdbcType(PostgreSQLEnumJdbcType.class)
    private CurrencyEnum currencyFrom;
    private BigDecimal amountFrom;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "c_to", columnDefinition = "currency")
//    @JdbcType(PostgreSQLEnumJdbcType.class)
    private CurrencyEnum currencyTo;
    private BigDecimal amountTo;

    private String sender;
    private String receiver;

    private String comment;
    private String code;

    private LocalDateTime updateAt;
}
