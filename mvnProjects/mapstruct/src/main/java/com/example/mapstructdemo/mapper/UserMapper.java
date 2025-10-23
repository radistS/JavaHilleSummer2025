package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.dto.*;
import com.example.mapstructdemo.model.*;
import org.mapstruct.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(uses = { AddressMapper.class },
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {

    DateTimeFormatter ISO = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    // === Entity -> DTO ===
    @Mappings({
        @Mapping(target = "fullName", expression = "java(joinName(entity.getFirstName(), entity.getLastName()))"),
        @Mapping(target = "city", source = "address.city"),
        @Mapping(target = "role", expression = "java(entity.getRole() == null ? null : entity.getRole().name())"),
        @Mapping(target = "createdAtIso", expression = "java(formatInstant(entity.getCreatedAt()))")
    })
    UserDto toDto(UserEntity entity);

    List<UserDto> toDtoList(List<UserEntity> entities);

    // === DTO/Request -> Entity ===
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "firstName", expression = "java(extractFirstName(req))"),
        @Mapping(target = "lastName", expression = "java(extractLastName(req))"),
        @Mapping(target = "address", source = "address"),
        @Mapping(target = "role", expression = "java(parseRole(req.getRole()))"),
        @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    })
    UserEntity fromCreate(CreateUserRequest req);

    // Partial update
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
        @Mapping(target = "email", source = "email"),
        @Mapping(target = "role", expression = "java(parseRole(dto.getRole()))"),
        @Mapping(target = "address.city", source = "city")
    })
    void update(@MappingTarget UserEntity target, UserDto dto);

    // Helpers
    default String joinName(String first, String last) {
        if (first == null && last == null) return null;
        if (first == null) return last;
        if (last == null) return first;
        return (first + " " + last).trim();
    }

    default String formatInstant(Instant instant) {
        if (instant == null) return null;
        return ISO.format(instant.atOffset(ZoneOffset.UTC));
    }

    default Role parseRole(String roleStr) {
        if (roleStr == null || roleStr.isBlank()) return Role.USER;
        return Role.valueOf(roleStr.trim().toUpperCase());
    }

    default String extractFirstName(CreateUserRequest req) { return req.getFirstName(); }
    default String extractLastName(CreateUserRequest req) { return req.getLastName(); }
}
