package com.exchanger.service.impl;

import com.exchanger.dto.UserRequest;
import com.exchanger.dto.UserResponse;
import com.exchanger.entity.UserEntity;
import com.exchanger.exceptions.NotUniqueDataExceprion;
import com.exchanger.exceptions.UserNotFoundException;
import com.exchanger.mapper.UserMapper;
import com.exchanger.repository.UserRepository;
import com.exchanger.service.UserService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UUID createUser(UserRequest user) {
        validateUser(user);
        return userRepository
            .save(userMapper.toUserEntity(user))
            .getId();
    }

    private void validateUser(UserRequest user) {
        int count = userRepository.findAllByEmailOrPhone(user.email(), user.phone()).size();
        if (count > 0) {
            throw new NotUniqueDataExceprion();
        }
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(
                String.format("User with id %s not found", userId)));

        return userMapper.toUserResponse(userEntity);
    }

    @Override
    public String activateUser(String phone, long chatId) {

        Optional<UserEntity> user = userRepository.findByPhone(phone);

        if (user.isPresent()) {
            UserEntity usr = user.get();
            usr.setActive(true).setTelegramChatId(chatId);
            userRepository.save(usr);

            return  "Hello " + usr.getFirstName() + ' ' + usr.getLastName();
        } else {
            log.warn("user {} not found", phone);
            return "SAME THING WRONG....";
        }
    }
}
