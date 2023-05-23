package ru.mirea.newsforum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.newsforum.entity.ImageEntity;
import ru.mirea.newsforum.repository.ImageRepository;
import ru.mirea.newsforum.util.ImageUtil;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageEntity uploadImage(MultipartFile multipartFile) throws IOException {
        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setName(multipartFile.getOriginalFilename());
        imageEntity.setType(multipartFile.getContentType());
        imageEntity.setContent(multipartFile.getBytes());
//        imageEntity.setContent(ImageUtil.compressImage(multipartFile.getBytes()));

        return imageRepository.save(imageEntity);
    }

    public byte[] downloadImage(long id) {
        ImageEntity imageEntity = imageRepository.findById(id).get();

        return imageEntity.getContent();
//        return ImageUtil.decompressImage(imageEntity.getContent());
    }
}
