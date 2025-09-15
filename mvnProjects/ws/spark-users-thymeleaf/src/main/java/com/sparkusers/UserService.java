package com.sparkusers;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUser(String id);
    List<User> getUsers();
    User editUser(User user);
    void deleteUser(String id);
    boolean userExist(String id);
}
