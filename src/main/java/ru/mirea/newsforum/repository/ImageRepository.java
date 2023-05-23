package ru.mirea.newsforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.newsforum.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
