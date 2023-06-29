package com.HarmyFounder.HIwow.controllers;

import com.HarmyFounder.HIwow.models.Comment;
import com.HarmyFounder.HIwow.models.User;
import com.HarmyFounder.HIwow.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/new")
    public Comment createComment(@RequestBody Comment comment, @AuthenticationPrincipal User user){
        return commentService.create(comment, user);
    }

}
