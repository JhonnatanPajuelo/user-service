package com.jpajuelo.userservice.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private Boolean isActivo = true;
    private Date createdAt=new Date();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
    private String profileImageName;

    public UserEntity(Long userId, String username, String password,Date date,Boolean active, Set<RoleEntity> roles, String profileImageName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createdAt = date;
        this.isActivo = active;
        this.roles = roles;
        this.profileImageName = profileImageName;
    }
}
