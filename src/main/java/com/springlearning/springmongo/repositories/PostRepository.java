package com.springlearning.springmongo.repositories;

import com.springlearning.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    //spring boot query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
