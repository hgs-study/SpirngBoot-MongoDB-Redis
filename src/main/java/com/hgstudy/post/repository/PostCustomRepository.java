package com.hgstudy.post.repository;

import com.hgstudy.post.entity.Post;

public interface PostCustomRepository {
    Post findByTitleAndContent(String title, String content);
}
