package com.hilllel.cw_08.except.validator;


import com.hilllel.cw_08.except.validator.exceptions.AgeException;
import com.hilllel.cw_08.except.validator.exceptions.EmailException;
import com.hilllel.cw_08.except.validator.exceptions.PhoneValidationException;
import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    void validate (User user) throws AgeException, EmailException, PhoneValidationException {
        if (!user.getEmail().contains("@")){
            throw new EmailException("email not valid ...");
        }

        if (user.getAge() < 18) {
            throw new AgeException(user.getAge().toString());
        }

        if (!user.getPhone().toLowerCase().startsWith("+380")){
            throw new PhoneValidationException("incorrect country phone prefix");
        }
    }

    void valid(User user){
        List<String> errors = new ArrayList<>();

        if (!user.getEmail().contains("@")){
            errors.add("E001");
        }

        if (user.getAge() < 18) {
            errors.add("E002");
        }

        if (!user.getPhone().toLowerCase().startsWith("+380")){
            errors.add("E003");
        }

        if (!errors.isEmpty())
            throw new RuntimeException(errors.toString());

    }
}
