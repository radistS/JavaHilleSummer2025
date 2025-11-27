package com.exchanger.repository;

import com.exchanger.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findAllByEmailOrPhone(String email, String phone);
    Optional<UserEntity> findByPhone(String phone);
}
