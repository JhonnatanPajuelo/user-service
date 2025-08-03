package com.jpajuelo.userservice.infrastructure.persistance.repository;

import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    @EntityGraph(attributePaths = "roles")
    Optional<UserEntity> findByUserIdAndIsActivoIsTrue(Long id);

    List<UserEntity> findAllByIsActivoIsTrue();

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByCorreo(String email);
}
