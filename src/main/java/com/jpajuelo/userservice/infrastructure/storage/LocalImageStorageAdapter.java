package com.jpajuelo.userservice.infrastructure.storage;

import com.jpajuelo.userservice.application.port.out.ImageStoragePort;
import com.jpajuelo.userservice.domain.exception.ImageStorageException;
import com.jpajuelo.userservice.domain.exception.invalidImageException;
import com.jpajuelo.userservice.infrastructure.web.response.ImageFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

@Component
public class LocalImageStorageAdapter implements ImageStoragePort {
    private final Path rootLocation= Paths.get("uploads/profile-images");
    public LocalImageStorageAdapter() {
        try{
            Files.createDirectories(rootLocation);
        }catch (IOException e){
            throw new ImageStorageException("Could not create directory",e);
        }
    }
    @Override
    public String saveImage(Long userId, MultipartFile image) {
        try {
            String extension =getFileExtension(image.getOriginalFilename()).orElseThrow(() -> new IllegalArgumentException("No extension found"));
            String filename = "user-" + userId + "."+ extension;
            Path destinationFile= rootLocation.resolve(filename).normalize();
            Files.copy(image.getInputStream(),destinationFile,StandardCopyOption.REPLACE_EXISTING);
            return filename;
        }catch (IOException e){
            throw new ImageStorageException("Could not save image",e);
        }
    }
    private Optional<String> getFileExtension(String filename) {
        return Optional.of(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf('.') + 1))
                .map(String::toLowerCase);
    }


    @Override
    public void deleteImage(String filename) {
        try{
           Path path = rootLocation.resolve(filename).normalize();
           Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new ImageStorageException("Could not delete images",e);
        }


    }

    @Override
    public ImageFile getImage(String filename) {
        try{
            Path path = rootLocation.resolve(filename).normalize();
            byte[] content = Files.readAllBytes(path);
            String mimeType = Files.probeContentType(path);
            return new ImageFile(content, mimeType != null ? mimeType : "application/octet-stream");
        }catch (IOException e){
            throw new ImageStorageException("Error read images",e);
        }
    }
}
