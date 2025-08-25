package com.hilllel.cw_16.steams;

import com.hilllel.cw_16.streamExample.businessObject.User;
import com.hilllel.cw_16.streamExample.businessObject.enumerators.Sex;
import com.hilllel.cw_16.streamExample.businessObject.service.UserService;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExFilter {
    public static void main(String[] args) {

        List<User>  users = UserService.getUserList();
        users.forEach(User::print);
        System.out.println("---------");

        Long f = users.stream() // iteration
            .filter(u -> u.getSex().equals(Sex.FEMALE)) // filter
            .count(); // concat
        Long m = users.stream()
            .filter(u -> u.getSex().equals(Sex.MALE))
            .count();

        System.out.println("f : " + f);
        System.out.println("m : " + m);
        System.out.println("total : " + (m + f));

        List<User>  fUsers = users.stream().filter(u -> u.getSex().equals(Sex.FEMALE)).toList(); // before 16
        System.out.println("---------");
        fUsers.forEach(User::print);

        Predicate<User> isMale = (u) -> u.getSex().equals(Sex.MALE);
        Predicate<User> isAdult = (u) -> u.getAge() > 18;

        System.out.println("---------");
        List<User>  mUsers = users.stream().filter(isMale.and(isAdult)).collect(Collectors.toList()); // toList()
        mUsers.forEach(User::print);


        // List.of()

    }
}
