package com.HarmyFounder.HIwow.services;

import com.HarmyFounder.HIwow.models.Comment;
import com.HarmyFounder.HIwow.models.User;
import com.HarmyFounder.HIwow.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Comment comment, User user){
        comment.setAuthor(user);
        return commentRepository.save(comment);
    }

}
