package com.jpajuelo.userservice.infrastructure.web.request;

import lombok.Getter;

@Getter
public class UserRequest {
    private String username;
    private String password;
}
