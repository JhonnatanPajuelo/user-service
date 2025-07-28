package com.jpajuelo.userservice.infrastructure.web.controller;

import com.jpajuelo.userservice.application.port.in.UserUseCase;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.web.mapper.UserDtoMapper;
import com.jpajuelo.userservice.infrastructure.web.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserUseCase userUseCase;
    private UserDtoMapper userDtoMapper;
    @Autowired
    public UserController(UserUseCase userUseCase, UserDtoMapper userDtoMapper) {
        this.userUseCase = userUseCase;
        this.userDtoMapper= userDtoMapper;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = userDtoMapper.toDomain(userRequest);
        return ResponseEntity.ok(userUseCase.createUser(user));
    }
}
