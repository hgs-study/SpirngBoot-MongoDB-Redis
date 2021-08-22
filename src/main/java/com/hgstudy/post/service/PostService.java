package com.hgstudy.post.service;

import com.hgstudy.post.entity.Post;
import com.hgstudy.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MongoTemplate mongoTemplate;

    public void save(Post post){
        postRepository.save(post);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }


    public Post findByTitle(String title){
        return postRepository.findByTitle(title);
    }

    public Post findByTitleAndContent(String title, String content){
        return postRepository.findByTitleAndContent(title,content);
    }

    public void updateContentByTitle(String title, String content){
        Query query = new Query(Criteria.where("title").is(title));

        Update update = new Update();
        update.set("content",content);

        mongoTemplate.updateFirst(query,update, Post.class);
    }

    public void removeByTitle(String title){
        Query query = new Query(Criteria.where("title").is(title));

        mongoTemplate.remove(query, Post.class);
    }


}
