package com.jpajuelo.userservice.infrastructure.web.request;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequest {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @NotBlank(message = "El correo no puede estar vacía")
    @Size(min = 6, message = "El correo debe tener al menos 6 caracteres")
    @Email(message = "El correo debe tener un formato valido")
    private String correo;
}
