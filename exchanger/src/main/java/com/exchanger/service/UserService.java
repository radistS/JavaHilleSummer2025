package com.exchanger.service;

import com.exchanger.dto.UserRequest;
import com.exchanger.dto.UserResponse;
import com.exchanger.entity.UserEntity;
import java.util.List;
import java.util.UUID;

public interface UserService {

    UUID createUser(UserRequest user);

    List<UserResponse> getUsers();

    UserResponse getUserById(UUID userId);

    String activateUser(String phone, long chatId);

    UserEntity findByPhone(String phone);
}
