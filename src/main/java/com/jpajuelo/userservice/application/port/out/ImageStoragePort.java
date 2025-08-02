package com.jpajuelo.userservice.application.port.out;
import com.jpajuelo.userservice.infrastructure.web.response.ImageFile;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


public interface ImageStoragePort {
    String saveImage(Long userId, MultipartFile image);
    void deleteImage(String filename);
    ImageFile getImage(String filename);
}
