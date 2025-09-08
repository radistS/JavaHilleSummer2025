package com.sparkjava;

import java.sql.SQLException;
import java.util.Collection;

public interface UserService {
    void addUser(User user) throws SQLException;

    Collection<User> getUsers() throws SQLException;

    User getUser(String id) throws SQLException;

    User editUser(User user) throws UserException;

    void deleteUser(String id);

    boolean userExist(String id);
}
