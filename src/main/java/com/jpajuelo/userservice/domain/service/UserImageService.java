package com.jpajuelo.userservice.domain.service;

import com.jpajuelo.userservice.application.port.in.UserImageUseCase;
import com.jpajuelo.userservice.application.port.in.UserUseCase;
import com.jpajuelo.userservice.application.port.out.ImageStoragePort;
import com.jpajuelo.userservice.application.port.out.UserRepositoryPort;
import com.jpajuelo.userservice.domain.exception.invalidImageException;
import com.jpajuelo.userservice.domain.model.User;
import com.jpajuelo.userservice.infrastructure.web.response.ImageFile;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@Transactional
@Slf4j
public class UserImageService implements UserImageUseCase{
    private static final long MAX_IMAGE_SIZE = 10 * 1024 * 1024;
    private final UserUseCase userService;
    private final ImageStoragePort imageStoragePort;
    private final UserRepositoryPort userRepository;
    public UserImageService(ImageStoragePort imageStoragePort, UserUseCase userService, UserRepositoryPort userRepository) {
        this.imageStoragePort = imageStoragePort;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public String uploadProfileImage(Long userId, MultipartFile image) {
        User user= userService.findById(userId);
        this.validarContentType(image);
        this.validarSizeImage(image);
        log.info("Imagen validada correctamente");
        String filename= imageStoragePort.saveImage(userId, image);
        user.setProfileImageName(filename);
        userRepository.saveUser(user);
        log.info("Imagen guardada correctamente");
        return filename;
    }

    @Override
    public void deleteProfileImage(Long userId) {
        User user = userService.findById(userId);
        if(user.getProfileImageName() == null) {
            throw new invalidImageException("El usuario no tiene una imagen de perfil");
        }
        imageStoragePort.deleteImage(user.getProfileImageName());
        user.setProfileImageName(null);
        userRepository.saveUser(user);
    }

    @Override
    public ImageFile getProfileImage(Long userId) {
        this.validarUser(userId);
        User user= userService.findById(userId);
        if(user.getProfileImageName() == null) {
            throw new invalidImageException("Image name is null");
        }
        return imageStoragePort.getImage(user.getProfileImageName());
    }


    private void validarSizeImage(MultipartFile image) {
        if (image.getSize() >MAX_IMAGE_SIZE) {
            throw new invalidImageException("Image size is too large");
        }
    }
    private void validarContentType(MultipartFile image) {
        if(!Objects.requireNonNull(image.getContentType()).startsWith("image/") ) {
            throw new invalidImageException("Image content type is not supported");
        }
    }
    public void validarUser(Long useriD) {
        userService.findById(useriD);
    }
}
