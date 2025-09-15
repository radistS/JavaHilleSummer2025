package com.sparkusers;

import java.util.*;

public class UserServiceInMemoryImpl implements UserService {
    private final Map<String, User> users = new LinkedHashMap<>();

    @Override
    public void addUser(User user) { users.put(user.getId(), user); }

    @Override
    public User getUser(String id) { return users.get(id); }

    @Override
    public List<User> getUsers() { return new ArrayList<>(users.values()); }

    @Override
    public User editUser(User user) {
        if (!users.containsKey(user.getId())) return null;
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUser(String id) { users.remove(id); }

    @Override
    public boolean userExist(String id) { return users.containsKey(id); }
}
