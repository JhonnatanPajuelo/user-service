package com.jpajuelo.userservice.infrastructure.persistance.repository;

import com.jpajuelo.userservice.infrastructure.persistance.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
