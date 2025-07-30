package com.jpajuelo.userservice.infrastructure.web.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
    private String username;
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

}
