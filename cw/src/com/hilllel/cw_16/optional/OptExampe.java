package com.hilllel.cw_16.optional;


import com.hilllel.cw_16.streamExample.businessObject.User;
import com.hilllel.cw_16.streamExample.businessObject.enumerators.Sex;
import com.hilllel.cw_16.streamExample.businessObject.exception.AgeException;
import java.util.Optional;

public class OptExampe {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(18);
        user.setSex(Sex.MALE);

        User userEmpty = null;

//        Optional<User> us = Optional.ofNullable(userEmpty);
//
//            System.out.println("-------");
//            System.out.println(us.isPresent());
//
//            Optional<User> userOptional = Optional.ofNullable(user);
//
//            System.out.println(userOptional.isPresent());
//            userOptional.ifPresent(User::print);
//
//            if (userOptional.isPresent()){
//                System.out.println(userOptional.get().getAge());
//        }


         Optional<User> userOptional = Optional.ofNullable(user);

        String name = userOptional.map(u -> u.getFirstName() + " " + u.getLastName()).orElse("error");

        System.out.println(name);

        user.setAge(23);

        User isAdult =  userOptional.filter(u -> u.getAge() > 18).orElseThrow(AgeException::new);

        boolean adult;
        if (userOptional.get().getAge() > 18) {
            adult = true;
        } else {
            throw new AgeException();
        }

        System.out.println(adult);
        System.out.println(isAdult);
    }
}
