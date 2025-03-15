package com.user.user.mapper;

import com.user.user.dto.UserDto;
import com.user.user.entity.User;

public class UserDtoMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

    }}
