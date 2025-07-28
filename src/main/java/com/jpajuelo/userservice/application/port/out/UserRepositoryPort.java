package com.jpajuelo.userservice.application.port.out;

import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.persistance.UserEntity;

import java.util.List;

public interface UserRepositoryPort {
    User saveUser(User user);
    User findUserById(Long idUser);
    List<User> findAllUsers();
    void deleteUserById(Long idUser);
}
