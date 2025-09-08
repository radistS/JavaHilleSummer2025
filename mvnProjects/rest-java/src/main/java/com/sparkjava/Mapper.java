package com.sparkjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {


    public static List<User> userRsToDto(ResultSet resultSet) throws SQLException {
        List<User> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(new User()
                .setId(resultSet.getString("id"))
                .setLastName(resultSet.getString("lastname"))
                .setFirstName(resultSet.getString("firstname"))
                .setEmail(resultSet.getString("email"))
            );
        }
        return students;

    }

    public static User userToDto(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            return new User()
                .setId(resultSet.getString("id"))
                .setLastName(resultSet.getString("lastname"))
                .setFirstName(resultSet.getString("firstname"))
                .setEmail(resultSet.getString("email"));
        }
       return new User();
    }
}
