package com.hgstudy.post.api;

import com.hgstudy.post.entity.Post;
import com.hgstudy.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void save(@RequestBody Post post){
        postService.save(post);
    }

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.findAll();
    }


    @GetMapping("/posts/{title}")
    public Post getPostByTitle(@PathVariable String title){
        return postService.findByTitle(title);
    }


    @GetMapping("/posts/{title}/{content}")
    public Post getPostByTitleAndContent(@PathVariable String title,
                                         @PathVariable String content){
        return postService.findByTitleAndContent(title,content);
    }

    @PatchMapping("/posts/{title}/{content}")
    public void updateContentByTitle(@PathVariable String title,
                                     @PathVariable String content){
        postService.updateContentByTitle(title,content);
    }

    @DeleteMapping("/posts/{title}")
    public void remove(@PathVariable String title){
        postService.removeByTitle(title);
    }


}
