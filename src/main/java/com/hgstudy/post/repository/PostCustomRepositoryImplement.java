package com.hgstudy.post.repository;

import com.hgstudy.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostCustomRepositoryImplement implements PostCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Post findByTitleAndContent(String title, String content) {
        return mongoTemplate.findOne(Query.query(Criteria
                                                    .where("title").is(title)
                                                    .and("content").is(content))
                                     , Post.class);
    }


}
