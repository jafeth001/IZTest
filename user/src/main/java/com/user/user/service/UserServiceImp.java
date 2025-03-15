package com.user.user.service;

import com.user.user.dto.UserDto;
import com.user.user.entity.User;
import com.user.user.mapper.UserDtoMapper;
import com.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id)
                .map(UserDtoMapper::mapToUserDto);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDtoMapper::mapToUserDto)
                .toList();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
