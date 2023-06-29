package com.HarmyFounder.HIwow.controllers;

import com.HarmyFounder.HIwow.models.User;
import com.HarmyFounder.HIwow.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{id}")
    public User getProfile(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("/{id}/sub")
    public User changeSubStatus(@PathVariable("id") User channel, @AuthenticationPrincipal User subscriber){
        if(channel.equals(subscriber)){
            return channel;
        } else {
            return profileService.changeSubStatus(channel, subscriber);
        }
    }

    

}
