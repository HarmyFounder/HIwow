package com.HarmyFounder.HIwow.services;

import com.HarmyFounder.HIwow.models.User;
import com.HarmyFounder.HIwow.repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {

    @Autowired
    private UserDetailRepo userDetailRepo;


    public User changeSubStatus(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        } else {
            subscribers.add(subscriber);
        }
        return userDetailRepo.save(channel);
    }
}
