package ru.mirea.newsforum.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.newsforum.entity.Post;
import ru.mirea.newsforum.repository.PostRepository;
import ru.mirea.newsforum.service.PostService;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
