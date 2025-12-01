package com.exchanger.repository;

import com.exchanger.entity.UserEntity;
import com.exchanger.entity.WalletEntity;
import com.exchanger.entity.enums.CurrencyEnum;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {

    Optional<WalletEntity> findAllByUserAndCurrency(UserEntity user, CurrencyEnum currency);

}
