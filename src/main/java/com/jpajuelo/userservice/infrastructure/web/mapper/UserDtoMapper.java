package com.jpajuelo.userservice.infrastructure.web.mapper;

import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.web.request.UserRequest;
import com.jpajuelo.userservice.infrastructure.web.request.UserUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public User toDomain(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        // Los campos ignorados:
        // - id → no se establece (null)
        // - isActivo → ya es true por defecto en el modelo
        // - roles → se queda como new HashSet<>()
        // - createdAt → se inicializa en el constructor
        return user;
    }

    public User toDomainFromUpdateRequest(Long id, UserUpdateRequest request) {
        User user = new User();
        user.setId(id);

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }

        return user;
    }

}
