package com.app.dto;

import com.app.validator.Phone;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class UserDto {
    @NotBlank(message = "Name cannot be blank") // not null and not empty
    String username;
    @Min(18)
    @Max(55)
    Integer age; // validate age between 18 .. 55
    @Length(min = 5, max = 10, message = "value length from 5 to 10")
    String password; // validate length between 5 .. 10
    @Phone // custom
    String phoneNumber;
    @Email
    String email;
    @Transient
    @Positive(message = "Price must be a positive value")
    Integer price;
}
