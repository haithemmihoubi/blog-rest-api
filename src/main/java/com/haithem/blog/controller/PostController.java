package com.haithem.blog.controller;

import com.haithem.blog.payload.PostDto;
import com.haithem.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }
    //? create a post method
    // this method will take a postDto as a parameter and will return a postDto
    // this method will be mapped to the following url : /api/posts and will accept POST requests
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody  PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }




}
