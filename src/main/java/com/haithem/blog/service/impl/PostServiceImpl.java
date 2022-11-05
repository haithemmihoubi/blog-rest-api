package com.haithem.blog.service.impl;

import com.haithem.blog.entity.Post;
import com.haithem.blog.payload.PostDto;
import com.haithem.blog.repository.PostRepository;
import com.haithem.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // convert the postDto to a post entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        // save the post entity to the database
        postRepository.save(post);
        // return the postDto
        return postDto;

    }





}