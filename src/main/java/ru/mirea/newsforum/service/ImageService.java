package ru.mirea.newsforum.service;

import org.springframework.web.multipart.MultipartFile;
import ru.mirea.newsforum.entity.ImageEntity;

import java.io.IOException;

public interface ImageService {
    ImageEntity uploadImage(MultipartFile multipartFile) throws IOException;
    byte[] downloadImage(long id);
}
