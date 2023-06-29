package com.HarmyFounder.HIwow.repositories;

import com.HarmyFounder.HIwow.models.Post;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = {"comments"})
    List<Post> findAll();

    List<Post> findByTag(String tag);

}
