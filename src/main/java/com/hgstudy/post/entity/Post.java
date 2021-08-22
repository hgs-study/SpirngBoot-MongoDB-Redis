package com.hgstudy.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "post")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private String author;


    public void toUpdate(Post post){
        this.id = post.id;
        this.title = post.title;
        this.content = post.content;
        this.author = post.author;
    }

}
