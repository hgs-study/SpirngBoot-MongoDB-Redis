package com.hgstudy.business.post.repository;

import com.hgstudy.business.post.entity.Post;

public interface PostCustomRepository {
    Post findByTitleAndContent(String title, String content);
}
