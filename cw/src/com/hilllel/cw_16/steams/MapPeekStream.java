package com.hilllel.cw_16.steams;

import com.hilllel.cw_16.streamExample.businessObject.User;
import com.hilllel.cw_16.streamExample.businessObject.enumerators.Sex;
import com.hilllel.cw_16.streamExample.businessObject.service.UserService;;
import java.util.List;

public class MapPeekStream {
    public static void main(String[] args) {


        List<User> users = UserService.getUserList();

        List<User> userList = users.stream()
                .filter(u -> u.getSex().equals(Sex.MALE))
                .peek(u -> {u.setId(1);}).toList();


        users.forEach(User::print);


    }
}
