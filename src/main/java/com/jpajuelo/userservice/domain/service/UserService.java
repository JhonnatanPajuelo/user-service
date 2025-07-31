package com.jpajuelo.userservice.domain.service;

import com.jpajuelo.userservice.application.port.in.UserUseCase;
import com.jpajuelo.userservice.application.port.out.RoleRepositoryPort;
import com.jpajuelo.userservice.application.port.out.UserRepositoryPort;
import com.jpajuelo.userservice.domain.exception.UserNotFoundException;
import com.jpajuelo.userservice.domain.model.Role;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.web.request.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserUseCase {
    private UserRepositoryPort userRepository;
    private RoleRepositoryPort roleRepository;

    public UserService(UserRepositoryPort userRepository, RoleRepositoryPort roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
    }
    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
    }

    @Override
    public User createUser(User user) {
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Role basicRole = roleRepository.findByName("BASIC")
                    .orElseThrow(() -> new RuntimeException("Rol BASIC no encontrado"));
            user.setRoles(Set.of(basicRole));
        }
        return userRepository.saveUser(user);
    }

    @Override
    public User updateInfoUser(Long IdUser, User request) {
        User userInBD = findById(IdUser);
        applyPartialUpdate(userInBD, request);
        return userRepository.saveUser(userInBD);
    }


    @Override
    public User updateActiveUser(Long idUser) {
        User user = findById(idUser);
        user.setIsActivo(false);
        return userRepository.saveUser(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        User user = findById(idUser);
        userRepository.deleteUserById(idUser);
    }

    public void applyPartialUpdate(User target, User source) {
        if (source.getUsername() != null && !source.getUsername().isEmpty()) target.setUsername(source.getUsername());
        if (source.getPassword() != null && !source.getPassword().isEmpty()) target.setPassword(source.getPassword());
        // Si tuvieras más campos editables, agregas aquí
    }

}
