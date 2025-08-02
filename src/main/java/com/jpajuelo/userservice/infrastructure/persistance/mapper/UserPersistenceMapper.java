package com.jpajuelo.userservice.infrastructure.persistance.mapper;

import com.jpajuelo.userservice.domain.model.Role;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.persistance.entity.RoleEntity;
import com.jpajuelo.userservice.infrastructure.persistance.entity.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class UserPersistenceMapper {
    public static UserEntity toEntity(User user) {
        Set<RoleEntity> roleEntities = user.getRoles().stream()
                .map(RolePersistenceMapper::toEntity)
                .collect(Collectors.toSet());

        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getIsActivo(),
                roleEntities,
                user.getProfileImageName()
        );
    }

    public static User toDomain(UserEntity entity) {
        Set<Role> roles = entity.getRoles().stream()
                .map(RolePersistenceMapper::toDomain)
                .collect(Collectors.toSet());

        return new User(
                entity.getUserId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getIsActivo(),
                entity.getCreatedAt(),
                roles,
                entity.getProfileImageName()
        );
    }
}

