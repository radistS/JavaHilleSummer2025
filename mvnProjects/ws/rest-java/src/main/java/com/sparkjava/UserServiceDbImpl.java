package com.sparkjava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserServiceDbImpl implements UserService {

    private final String INSERT = """
        insert into user_table (id, firstname, lastname, email)
        values ('%s', '%s', '%s', '%s');
        """;

    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(String.format(
            INSERT,
            user.getId().toString(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail()));
        connection.close();
    }

    @Override
    public Collection<User> getUsers() throws SQLException {
        return List.of();
    }

    @Override
    public User getUser(String id) throws SQLException {
        return null;
    }

    @Override
    public User editUser(User user) throws UserException {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public boolean userExist(String id) {
        return false;
    }
}
