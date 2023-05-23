package ru.mirea.newsforum.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.newsforum.dto.PostDTO;
import ru.mirea.newsforum.entity.Post;
import ru.mirea.newsforum.service.PostService;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public ResponseEntity<Post> save(@RequestBody PostDTO postDTO) {
//        Post post = new Post()
//                .setGroups(postDTO.getGroups())
//                .setText(postDTO.getText())
//                .setPhoto(postDTO.getPhoto());
//
//        return ResponseEntity.ok(postService.save(post));
        return null;
    }
}
