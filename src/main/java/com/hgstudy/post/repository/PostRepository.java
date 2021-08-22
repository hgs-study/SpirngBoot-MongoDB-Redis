package com.hgstudy.post.repository;

import com.hgstudy.post.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends MongoRepository<Post,String> {

    Post findById(Long id);

    Post findByTitle(String title);

}
