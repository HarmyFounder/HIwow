package com.HarmyFounder.HIwow.controllers;

import com.HarmyFounder.HIwow.models.Post;
import com.HarmyFounder.HIwow.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post getCertainPost(@PathVariable("id") Post post) {
        return post;
    }

    @PostMapping("/new")
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/{id}/edit")
    public Post updatePost(@PathVariable("id")Post postTobeUpdated, @RequestBody Post updatedPost){
        return postService.update(postTobeUpdated,updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Post post){
        postService.delete(post);
    }

}
