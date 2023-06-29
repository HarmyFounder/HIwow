package com.HarmyFounder.HIwow.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {

    @Id
    private String id;

    private String name;
    private String userPic;
    private String locale;
    private String email;
    private String gender;


    @ElementCollection(targetClass = Role.class,
    fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_subscription",
    joinColumns = @JoinColumn(name = "subscriber_id"),
    inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private Set<User> subscriptions = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_subscription",
    joinColumns = @JoinColumn(name = "channel_id"),
    inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    private Set<User> subscribers = new HashSet<>();

    public Set<User> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
