package com.user.user.service.serviceImpl;

import com.user.user.dto.UserDto;
import com.user.user.entity.User;
import com.user.user.exception.NotFoundException;
import com.user.user.mapper.UserDtoMapper;
import com.user.user.repository.UserRepository;
import com.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserDto> findById(Long id) throws NotFoundException {
        return Optional.ofNullable(userRepository.findById(id)
                .map(UserDtoMapper::mapToUserDto)
                .orElseThrow(() -> new NotFoundException("User not found")));
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
