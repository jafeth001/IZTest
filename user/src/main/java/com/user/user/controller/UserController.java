package com.user.user.controller;

import com.user.user.dto.UserDto;
import com.user.user.entity.User;
import com.user.user.exception.NotFoundException;
import com.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping
    public ResponseEntity<Optional<UserDto>> getUserById(Long id) throws NotFoundException {
        return ResponseEntity.ok(userService.findById(id));
    }
}
