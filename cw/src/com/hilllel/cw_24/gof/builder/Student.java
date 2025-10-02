package com.hilllel.cw_24.gof.builder;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Student {
    UUID id;
    String name;
    int age;
    String gender;
    String email;
    String phone;

    public Student() {
    }
}
