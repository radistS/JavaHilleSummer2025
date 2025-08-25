package com.hilllel.cw_16.optional;


import com.hilllel.cw_16.streamExample.businessObject.User;
import java.util.Optional;

public class OptionaConstr {
    public static void main(String[] args) {
        User us = new User();

        Optional<User> oUser = Optional.of(us);
        oUser.ifPresent(oUser.get()::printUser);


        oUser.ifPresent(us::printUser);
        Optional<User> user = Optional.ofNullable(us);

        System.out.println(user.isPresent());
        System.out.println(user);

        Optional<User> userEmpty = Optional.empty();
        System.out.println(userEmpty.isPresent());

    }
}
