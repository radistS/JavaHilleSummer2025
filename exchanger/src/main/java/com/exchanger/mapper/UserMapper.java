package com.exchanger.mapper;

import com.exchanger.dto.UserRequest;
import com.exchanger.dto.UserResponse;
import com.exchanger.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toUserEntity(UserRequest request);

    UserResponse toUserResponse(UserEntity entity);

}
