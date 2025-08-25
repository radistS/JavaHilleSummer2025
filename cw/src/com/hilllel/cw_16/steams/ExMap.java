package com.hilllel.cw_16.steams;

import com.hilllel.cw_16.streamExample.businessObject.User;
import com.hilllel.cw_16.streamExample.businessObject.enumerators.Sex;
import com.hilllel.cw_16.streamExample.businessObject.service.UserService;
import java.util.Comparator;
import java.util.List;

public class ExMap {
    public static void main(String[] args) {
        List<User> users = UserService.getUserList();
        users.forEach(User::print);
//        users.stream()
//                .sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);

        System.out.println("---------");
        List<String> userFullName = users.stream()
//                .filter(u -> u.getSex().equals(Sex.MALE))
            .skip(10)
                .peek(u-> u.setFullName(u.getFirstName() + " " + u.getLastName()))
                .sorted(Comparator.comparing(User::getFullName))
                .map(User::getFullName)
                .toList();

        userFullName.forEach(System.out::println);
        System.out.println("-------");

        users.forEach(System.out::println);

    }


}
