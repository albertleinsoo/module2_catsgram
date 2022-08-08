package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private final List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> findAll() {
        return posts;
    }

    @PostMapping(value = "/post")
    public void create(@RequestBody Post post) {
        posts.add(post);
    }
}