package com.jpajuelo.userservice.domain.model;

import lombok.Getter;
import java.util.HashSet;
import java.util.Set;
@Getter
public class Role {
    private Long id;
    private String name;
    private Boolean isActivo = true;
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(Long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
}
