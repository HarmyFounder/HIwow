package com.HarmyFounder.HIwow.services;

import com.HarmyFounder.HIwow.models.Post;
import com.HarmyFounder.HIwow.repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post postTobeUpdated, Post updatedPost) {
        BeanUtils.copyProperties(updatedPost, postTobeUpdated, "id");
        return postRepository.save(postTobeUpdated);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public List<Post> getByTag(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return postRepository.findByTag(filter);
        } else {
            return postRepository.findAll();
        }

    }

}
