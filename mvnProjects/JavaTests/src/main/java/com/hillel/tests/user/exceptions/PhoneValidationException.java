package com.hillel.tests.user.exceptions;

public class PhoneValidationException extends RuntimeException{
    public PhoneValidationException(String message) {
        super(message);
    }
}
