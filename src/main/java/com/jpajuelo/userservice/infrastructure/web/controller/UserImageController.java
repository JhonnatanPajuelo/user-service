package com.jpajuelo.userservice.infrastructure.web.controller;
import com.jpajuelo.userservice.application.port.in.UserImageUseCase;
import com.jpajuelo.userservice.infrastructure.web.response.ImageFile;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/images")
@Validated
public class UserImageController {

    private final UserImageUseCase userImageUseCase;

    public UserImageController(UserImageUseCase userImageUseCase) {
        this.userImageUseCase = userImageUseCase;
    }

    // SUBIR o ACTUALIZAR imagen
    @PostMapping("/updateImage/{userId}")
    public ResponseEntity<String> uploadProfileImage(
            @PathVariable @NotNull @Positive Long userId,
            @RequestParam("image") @NotNull MultipartFile image) {
        String filename = userImageUseCase.uploadProfileImage(userId, image);
        return ResponseEntity.ok("Imagen subida exitosamente: " + filename);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<byte[]> getProfileImage(
            @PathVariable @NotNull @Positive Long userId) {
        ImageFile image = userImageUseCase.getProfileImage(userId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .body(image.getContent());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteProfileImage(
            @PathVariable @NotNull @Positive Long userId) {
        userImageUseCase.deleteProfileImage(userId);
        return ResponseEntity.ok("Imagen eliminada exitosamente");
    }
}
