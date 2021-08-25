package com.hgstudy.business.post.repository;

import com.hgstudy.business.post.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends PostCustomRepository, MongoRepository<Post,Long> {
    Post findByTitle(String title);
}
