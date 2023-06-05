package ru.mirea.newsforum.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.newsforum.dto.PostDTO;
import ru.mirea.newsforum.entity.GroupEntity;
import ru.mirea.newsforum.entity.Post;
import ru.mirea.newsforum.service.GroupService;
import ru.mirea.newsforum.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final GroupService groupService;

    @GetMapping("/get")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> savePost(@RequestBody PostDTO postDTO) {
        List<GroupEntity> groups = groupService.parseGroups(postDTO.getGroups());
        log.warn(groups.toString());

        Post post = new Post()
                .setGroups(groups)
                .setHeader(postDTO.getHeader())
                .setContent(postDTO.getContent())
                .setImageUrl(postDTO.getImageUrl());

        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable("id") long id) {
        postService.deleteById(id);
    }
}
