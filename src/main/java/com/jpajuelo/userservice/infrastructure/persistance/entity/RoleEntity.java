package com.jpajuelo.userservice.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
@NoArgsConstructor
@Getter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RoleId;
    private String name;
    private Boolean isActivo = true;
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    public RoleEntity(long roleId, String name, Set<UserEntity> users) {
        this.RoleId = roleId;
        this.name = name;
        this.users = users;
    }
}
