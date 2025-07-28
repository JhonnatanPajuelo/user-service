package com.jpajuelo.userservice.infrastructure.persistance;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    private String username;
    private String password;
    private Boolean isActivo = true;
    private Date createdAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity(Long userId, String username, String password,Set<RoleEntity> roles) {
        this.UserId = userId;
        this.username = username;
        this.password = password;
        this.createdAt = new Date();
        this.isActivo = true;
        this.roles = roles;
    }
}
