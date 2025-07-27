package com.jpajuelo.userservice.infrastructure.persistance;

import com.jpajuelo.userservice.domain.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserId;
    private String username;
    private String password;
    private Boolean isActivo = true;
    private Set<Role> roles = new HashSet<>();

    public UserEntity(long userId, String username, String password, Set<Role> roles) {
        UserId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
