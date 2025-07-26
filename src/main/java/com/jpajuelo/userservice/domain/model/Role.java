package com.jpajuelo.userservice.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Long id;
    private String name;
    private Boolean isActivo = true;
    private Set<User> users = new HashSet<>();

}
