package com.jpajuelo.userservice.domain.service;

import com.jpajuelo.userservice.application.port.in.UserUseCase;
import com.jpajuelo.userservice.application.port.out.RoleRepositoryPort;
import com.jpajuelo.userservice.application.port.out.UserRepositoryPort;
import com.jpajuelo.userservice.domain.model.Role;
import com.jpajuelo.userservice.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
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
    public User updateUser(Long idUser) {
        return null;
    }

    @Override
    public User updateActiveUser(Long idUser) {
        return null;
    }

    @Override
    public void deleteUser(Long idUser) {

    }
}
