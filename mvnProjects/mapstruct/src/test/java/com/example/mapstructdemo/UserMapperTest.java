package com.example.mapstructdemo;

import com.example.mapstructdemo.dto.*;
import com.example.mapstructdemo.mapper.UserMapper;
import com.example.mapstructdemo.model.*;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    void testToDto() {
        AddressEntity addr = new AddressEntity();
        addr.setCity("Kyiv"); addr.setStreet("Main"); addr.setZip("01001");

        UserEntity e = new UserEntity();
        e.setId(1L);
        e.setFirstName("Ivan");
        e.setLastName("Petrenko");
        e.setEmail("ivan@example.com");
        e.setAddress(addr);
        e.setRole(Role.ADMIN);
        e.setCreatedAt(Instant.parse("2025-01-01T12:00:00Z"));

        UserDto dto = mapper.toDto(e);
        assertEquals("Ivan Petrenko", dto.getFullName());
        assertEquals("Kyiv", dto.getCity());
        assertEquals("ADMIN", dto.getRole());
        assertNotNull(dto.getCreatedAtIso());
    }

    @Test
    void testFromCreateAndUpdate() {
        CreateUserRequest req = new CreateUserRequest();
        req.setFirstName("Olena");
        req.setLastName("Shevchenko");
        req.setEmail("olena@example.com");
        AddressDto ad = new AddressDto();
        ad.setCity("Lviv"); ad.setStreet("Green"); ad.setZip("79000");
        req.setAddress(ad);
        req.setRole("user");

        UserEntity entity = mapper.fromCreate(req);
        assertEquals(Role.USER, entity.getRole());
        assertEquals("Olena", entity.getFirstName());
        assertNotNull(entity.getCreatedAt());

        // Patch update from DTO
        UserDto patch = new UserDto();
        patch.setEmail("olena.new@example.com");
        patch.setRole("ADMIN");
        patch.setCity("Odesa");

        mapper.update(entity, patch);
        assertEquals("olena.new@example.com", entity.getEmail());
        assertEquals(Role.ADMIN, entity.getRole());
        assertEquals("Odesa", entity.getAddress().getCity());
    }
}
