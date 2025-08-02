package com.jpajuelo.userservice.application.port.in;

import com.jpajuelo.userservice.infrastructure.web.response.ImageFile;
import org.springframework.web.multipart.MultipartFile;

public interface UserImageUseCase {

    /**
     * Sube o reemplaza la imagen de perfil de un usuario.
     *
     * @param userId ID del usuario
     * @param image  Imagen en formato MultipartFile
     * @return La URL o el nombre del archivo almacenado
     */
    String uploadProfileImage(Long userId, MultipartFile image);

    /**
     * Elimina la imagen de perfil del usuario.
     *
     * @param userId ID del usuario
     */
    void deleteProfileImage(Long userId);

    /**
     * Devuelve la imagen de perfil del usuario en forma de array de bytes.
     *
     * @param userId ID del usuario
     * @return Imagen como array de bytes
     */
    ImageFile getProfileImage(Long userId);
}
