package com.jpajuelo.userservice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private Boolean isActivo = true;
    private Set<Role> roles = new HashSet<>();
    private Date createdAt= new Date();
    private String profileImageName;
    public User() {}
    public User(Long id, String username, String password,Boolean active,Date date,Set<Role> roles, String profileImageName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isActivo=active;
        this.createdAt = date;
        this.profileImageName = profileImageName;
    }

}
