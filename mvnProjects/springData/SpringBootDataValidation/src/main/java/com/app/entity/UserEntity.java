package com.app.entity;

import com.app.validator.Phone;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class UserEntity extends BaseEntity {
//    @NotBlank(message = "Name cannot be blank")
    String username;
//    @Min(value = 5, message = "value between 5 .. 10")
//    @Max(value = 10, message = "value between 5 .. 10")
    String password;
    @Phone
    String phoneNumber;
    @Email
    String email;
//    @Transient
//    @Positive(message = "Price must be a positive value")
//    Integer price;
}
