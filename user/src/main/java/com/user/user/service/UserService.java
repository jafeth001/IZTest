package com.user.user.service;

import com.user.user.dto.UserDto;
import com.user.user.entity.User;
import com.user.user.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDto> findById(Long id) throws NotFoundException;

    List<UserDto> findAll();

    User save(User user);
}
