package com.hillel.springsecurity.rest;

import com.hillel.springsecurity.security.SystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sec/user")
@AllArgsConstructor
public class UserController {

    private final SystemUserService systemUserService;

    @PostMapping
//    @PreAuthorize("hasAuthority('developers:write')")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long create(@RequestBody SystemUser systemUser) {

        return systemUserService.createSystemUser(systemUser);
    }

}
