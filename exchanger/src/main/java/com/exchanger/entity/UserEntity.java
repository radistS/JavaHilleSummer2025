package com.exchanger.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "users")
public class UserEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean active;
    private Long telegramChatId;
}
