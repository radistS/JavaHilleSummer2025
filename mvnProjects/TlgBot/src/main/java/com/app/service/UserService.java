package com.app.service;

import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.mapper.UserMapper;
import com.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void createNewUser(Message msg) {
        var chatId = msg.getChatId().toString();
        var userByChat = getUserByChat(chatId);
        User newUser = new User();
        if (userByChat.isEmpty()) {
            newUser.setChatId(msg.getChatId().toString());
            newUser.setName(msg.getFrom().getLastName() + " " + msg.getFrom().getFirstName());
            newUser.setTlgName(msg.getFrom().getUserName());
           createUser(newUser);
        }
    }


    public User createUser(User user) {
       return userRepository.save(user);

    }

    public Optional<User> getUserByChat(String chatId) {
        return userRepository.getUserByChatId(chatId);

    }

    public List<UserDto> getUserList(){
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
