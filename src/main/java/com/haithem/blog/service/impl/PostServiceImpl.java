package com.haithem.blog.service.impl;

import com.haithem.blog.entity.Post;
import com.haithem.blog.payload.PostDto;
import com.haithem.blog.repository.PostRepository;
import com.haithem.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    // map  entities to DTOs

    // map  dto to entities

    PostDto MapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        postDto.setId(post.getId());
        return postDto;

    }

    // map  dto to entities
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        post.setId(postDto.getId());
        return post;

    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // convert the postDto to a post entity
        Post post = mapToEntity(postDto);
        // save the post entity to the database
        Post newPost = postRepository.save(post);
        // convert the post entity to a postDto
        PostDto postResponse = MapToDto(newPost);
        return postResponse;

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::MapToDto).collect(Collectors.toList());

    }


}
