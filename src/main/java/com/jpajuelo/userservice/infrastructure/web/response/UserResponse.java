package com.jpajuelo.userservice.infrastructure.web.response;

import com.jpajuelo.userservice.domain.model.Role;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private Boolean isActivo = true;
    private Set<Role> roles = new HashSet<>();
    private Date createdAt;
}
