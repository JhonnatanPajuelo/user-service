package com.jpajuelo.userservice.application.port.in;

import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.persistance.UserEntity;

import java.util.List;

public interface UserUseCase {
 List<User> findAll();
 User findById(Long id);
 User createUser(User user);
 User updateUser(Long idUser);
 User updateActiveUser(Long idUser);
 void deleteUser(Long idUser);
}
