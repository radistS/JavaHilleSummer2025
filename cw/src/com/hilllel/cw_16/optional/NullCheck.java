package com.hilllel.cw_16.optional;

import com.hilllel.cw_16.streamExample.businessObject.User;
import java.util.Objects;
import java.util.Optional;

public class NullCheck {
    public static void main(String[] args) {
        User user = null;

        if (Objects.nonNull(getUser(user))){
            System.out.println("not null");
        } else {
            System.out.println("null");
        }
    }

    public static Optional<User> getUser(User user){
        return Optional.ofNullable(user);
    }
}
