package com.jpajuelo.userservice.application.port.out;

import com.jpajuelo.userservice.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User saveUser(User user);
    Optional<User> findUserById(Long idUser);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<User> findAllUsers();
    void deleteUserById(Long idUser);
}
