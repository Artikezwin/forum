package ru.mirea.newsforum.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.newsforum.entity.ImageEntity;
import ru.mirea.newsforum.repository.ImageRepository;
import ru.mirea.newsforum.service.ImageService;

import java.awt.*;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("upload") MultipartFile multipartFile) throws IOException {
        imageService.uploadImage(multipartFile);
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long imageId) {
//        byte[] image = imageRepository.findById(imageId)
//                .orElseThrow()
//                .getContent();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_PNG);
//        headers.setContentLength(image.length);
//
//        return new HttpEntity<>(image, headers);
////        return new ByteArrayResource(image);
        byte[] bytes = imageService.downloadImage(imageId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(bytes);
    }
}
