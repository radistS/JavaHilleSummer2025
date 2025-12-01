package com.exchanger.entity;

import com.exchanger.entity.enums.CurrencyEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.springframework.data.annotation.LastModifiedDate;


@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "wallet")
public class WalletEntity extends BaseEntity{
//    @Enumerated(EnumType.STRING)
//    @Column(name = "currency", columnDefinition = "currency")
//    @JdbcType(PostgreSQLEnumJdbcType.class)
    private CurrencyEnum currency;
    private BigDecimal balance;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
