package com.hilllel.cw_16.predicat;


import com.hilllel.cw_16.streamExample.businessObject.User;
import com.hilllel.cw_16.streamExample.businessObject.enumerators.Sex;
import java.util.function.Predicate;

public class PredicatExample {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(19);
        user.setSex(Sex.FEMALE);

        Predicate<User> isAdult = (u) -> u.getAge() > 18; // true
        Predicate<User> isChild = (u) -> u.getAge() <= 18; // false
        Predicate<User> isMale = (u) -> u.getSex().equals(Sex.MALE);
        Predicate<User> isFemale = (u) -> u.getSex().equals(Sex.FEMALE);

        System.out.println(isAdult.test(user));
        System.out.println(userNameIvanov().test(user));
        System.out.println(isAdult.and(isFemale).test(user));

       // if (XX || YY && EE)

    }

    static Predicate<User> userNameIvanov() {
       return u -> u.getLastName().equals("Ivanov");
    }

}
