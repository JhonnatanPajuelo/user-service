package com.jpajuelo.userservice.infrastructure.web.controller;

import com.jpajuelo.userservice.application.port.in.UserUseCase;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.web.mapper.UserDtoMapper;
import com.jpajuelo.userservice.infrastructure.web.request.UserRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private UserUseCase userUseCase;
    private UserDtoMapper userDtoMapper;
    @Autowired
    public UserController(UserUseCase userUseCase, UserDtoMapper userDtoMapper) {
        this.userUseCase = userUseCase;
        this.userDtoMapper= userDtoMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userDtoMapper.toDomain(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUseCase.createUser(user));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> findUserByID(@PathVariable
                                                 @NotNull(message = "El id es obligatorio")
                                                    @Positive(message = "El id debe ser positivo") Long idUser) {
        return ResponseEntity.status(HttpStatus.OK).body(userUseCase.findById(idUser));

    }
}
