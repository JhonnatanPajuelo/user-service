package com.jpajuelo.userservice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter

public class User {
    private Long id;
    private String username;
    private String password;
    private Boolean isActivo = true;
    private Set<Role> roles = new HashSet<>();
    public User() {}
    public User(Long id, String username, String password,Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
