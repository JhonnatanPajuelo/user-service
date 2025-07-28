package com.jpajuelo.userservice.application.port.out;

import com.jpajuelo.userservice.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositoryPort{
    Optional<Role> findByName(String name);
}
