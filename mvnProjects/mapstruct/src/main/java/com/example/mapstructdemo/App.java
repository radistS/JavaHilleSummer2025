package com.example.mapstructdemo;

import com.example.mapstructdemo.dto.*;
import com.example.mapstructdemo.mapper.UserMapper;
import com.example.mapstructdemo.model.*;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);

        AddressEntity addr = new AddressEntity();
        addr.setCity("Kyiv");
        addr.setStreet("Main");
        addr.setZip("01001");

        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setFirstName("Ivan");
        entity.setLastName("Petrenko");
        entity.setEmail("ivan@example.com");
        entity.setAddress(addr);
        entity.setRole(Role.ADMIN);
        entity.setCreatedAt(Instant.parse("2025-01-01T12:00:00Z"));

        UserDto dto = userMapper.toDto(entity);
        System.out.println("Entity -> DTO: " + dto);

        CreateUserRequest req = new CreateUserRequest();
        req.setFirstName("Olena");
        req.setLastName("Shevchenko");
        req.setEmail("olena@example.com");
        AddressDto ad = new AddressDto();
        ad.setCity("Lviv"); ad.setStreet("Green"); ad.setZip("79000");
        req.setAddress(ad);
        req.setRole("user");

        UserEntity fromReq = userMapper.fromCreate(req);
        System.out.println("Create -> Entity: " + fromReq);

        // Collection demo
        List<UserDto> list = userMapper.toDtoList(List.of(entity));
        System.out.println("List size: " + list.size());
    }
}
