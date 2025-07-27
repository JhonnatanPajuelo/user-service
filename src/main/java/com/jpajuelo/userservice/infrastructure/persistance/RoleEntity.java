package com.jpajuelo.userservice.infrastructure.persistance;

import com.jpajuelo.userservice.domain.model.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RoleId;
    private String name;
    private Boolean isActivo = true;
    private Set<User> users = new HashSet<>();
}
