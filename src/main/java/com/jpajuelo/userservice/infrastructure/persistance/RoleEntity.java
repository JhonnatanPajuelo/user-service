package com.jpajuelo.userservice.infrastructure.persistance;

import com.jpajuelo.userservice.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
@NoArgsConstructor
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RoleId;
    private String name;
    private Boolean isActivo = true;
    private Set<User> users = new HashSet<>();

    public RoleEntity(long roleId, String name, Set<User> users) {
        RoleId = roleId;
        this.name = name;
        this.users = users;
    }
}
