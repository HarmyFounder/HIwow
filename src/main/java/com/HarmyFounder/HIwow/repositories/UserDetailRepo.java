package com.HarmyFounder.HIwow.repositories;

import com.HarmyFounder.HIwow.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailRepo extends JpaRepository<User, String> {

    @EntityGraph(attributePaths = {"subscriptions", "subscribers"})
    List<User> findAll();
}
