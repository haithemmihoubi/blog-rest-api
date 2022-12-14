package com.haithem.blog.controller;

import com.haithem.blog.entity.Post;
import com.haithem.blog.payload.PostDto;
import com.haithem.blog.payload.PostResponse;
import com.haithem.blog.service.PostService;
import com.haithem.blog.service.impl.PostServiceImpl;
import com.haithem.blog.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }


    // get all posts
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue =AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam(value = "sortDirection", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDirection) {


        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDirection);
    }

    // get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable Long id) {
        return new ResponseEntity<PostDto>(postService.updatePostById(id, postDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDto> deletePostById(@PathVariable Long id) {
        return new ResponseEntity<PostDto>(postService.deletePostById(id), HttpStatus.OK);
    }

}
