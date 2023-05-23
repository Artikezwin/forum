package ru.mirea.newsforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.newsforum.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
