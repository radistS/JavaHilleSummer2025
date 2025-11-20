package com.hillel.springsecurity.security;

import com.hillel.springsecurity.model.Role;
import com.hillel.springsecurity.model.Status;
import com.hillel.springsecurity.model.User;
import com.hillel.springsecurity.repository.UserRepository;
import com.hillel.springsecurity.rest.SystemUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemUserService {

    private final UserRepository userRepository;

    public Long createSystemUser(SystemUser user){
        User sysUser = new User();
        sysUser.setEmail(user.getEmail());
        sysUser.setPhone(user.getPhone());
        sysUser.setPassword(encodePassword(user.getPassword()));
        sysUser.setRole(Role.USER);
        sysUser.setStatus(Status.ACTIVE);
        return userRepository.save(sysUser).getId();
    }

    private String encodePassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        return bCryptPasswordEncoder.encode(password);
    }

}
