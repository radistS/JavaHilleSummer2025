package com.sparkjava;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserServiceInMemoryImpl implements UserService {

    private HashMap<String, User> userMap;

    public UserServiceInMemoryImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) throws SQLException {
        userMap.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUsers() throws SQLException {
        return userMap.values();
    }

    @Override
    public User getUser(String id) throws SQLException {
        return userMap.get(id);
    }

    @Override
    public User editUser(User user) throws UserException {
        try {
            if (user.getId() == null)
                throw new UserException("ID cannot be blank");

            User toEdit = userMap.get(user.getId());

            if (toEdit == null)
                throw new UserException("User not found");

            if (user.getEmail() != null) {
                toEdit.setEmail(user.getEmail());
            }
            if (user.getFirstName() != null) {
                toEdit.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                toEdit.setLastName(user.getLastName());
            }
            if (user.getId() != null) {
                toEdit.setId(user.getId());
            }

            return toEdit;
        } catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        userMap.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return userMap.containsKey(id);
    }
}
