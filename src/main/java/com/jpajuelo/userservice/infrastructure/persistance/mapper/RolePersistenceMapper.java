package com.jpajuelo.userservice.infrastructure.persistance.mapper;


import com.jpajuelo.userservice.domain.model.Role;
import com.jpajuelo.userservice.infrastructure.persistance.entity.RoleEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RolePersistenceMapper {

    public static RoleEntity toEntity(Role role) {
        if (role == null) return null;

        return new RoleEntity(
                role.getId(),
                role.getName(),
                new HashSet<>()
        );
    }

    public static Role toDomain(RoleEntity roleEntity) {
        if (roleEntity == null) return null;

        return new Role(
                roleEntity.getRoleId(),
                roleEntity.getName(),
                roleEntity.getIsActivo()
        );
    }

    public static Set<RoleEntity> toEntitySet(Set<Role> roles) {
        if (roles == null) return new HashSet<>();
        return roles.stream()
                .map(RolePersistenceMapper::toEntity)
                .collect(Collectors.toSet());
    }

    public static Set<Role> toDomainSet(Set<RoleEntity> entities) {
        if (entities == null) return new HashSet<>();
        return entities.stream()
                .map(RolePersistenceMapper::toDomain)
                .collect(Collectors.toSet());
    }
}

