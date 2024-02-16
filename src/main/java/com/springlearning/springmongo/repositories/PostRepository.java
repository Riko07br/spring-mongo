package com.springlearning.springmongo.repositories;

import com.springlearning.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    //spring boot query method
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

    @Query("{ $and: [ { date: { $gte: ?1 } } ," +
            " { date: { $lte: ?2 } } ," +
            " { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.body': { $regex: ?0, $options: 'i' } } ] } " +
            "] }")
    List<Post> findAll(String text, Date minDate, Date maxDate);
}
