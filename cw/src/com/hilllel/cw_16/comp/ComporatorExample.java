package com.hilllel.cw_16.comp;

import com.hilllel.cw_16.streamExample.businessObject.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComporatorExample {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Ivan"));
        userList.add(new User("Sveta"));
        userList.add(new User("Anna", "3",34));
        userList.add(new User("Anna", "3",12));
        userList.add(new User("Alex", "3",12));
        userList.add(new User("Alex", "2",43));
        userList.add(new User("Alex", "1",34));
        userList.add(new User("Petr", "1",44));

        Comparator<User> userComparator = Comparator.comparing(User::getFirstName);
        Comparator<User> ageComparator = Comparator.comparing(User::getAge);


        User user1 = new User("Ivan");
        User user2 = new User("tSavetaa");
        User user3 = new User("Ivan");

        System.out.println(userComparator.compare(user1, user2));
        System.out.println(userComparator.compare(user1, user3));

        userList.forEach(System.out::println);
        System.out.println("-------");
        System.out.println();
        userList.sort(userComparator
                .thenComparing(User::getLastName)
                .thenComparing(ageComparator)
//                .reversed()
        );

        userList.forEach(System.out::println);

//        userList.sort((User u1, User u2) -> u1.getAge().compareTo(u2.getAge()));
//        userList.sort(Comparator.comparing(User::getAge));
    }
}


