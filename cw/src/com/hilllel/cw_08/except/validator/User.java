package com.hilllel.cw_08.except.validator;

import java.util.Objects;

public class User {
    String name;
    String email;
    Integer age;
    String phone;

    public User(String name, String email, Integer age, String phone) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email)
            && Objects.equals(age, user.age) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(age);
        result = 31 * result + Objects.hashCode(phone);
        return result;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
