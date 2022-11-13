package com.haithem.blog.service.impl;

import com.haithem.blog.entity.Post;
import com.haithem.blog.exception.ResourceNotFoundException;
import com.haithem.blog.payload.PostDto;
import com.haithem.blog.repository.PostRepository;
import com.haithem.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<PostDto> getAllPosts(int pageNo, int pageSize) {
 // create a page request object with get two parameters pageNo and pageSize
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        // get all posts from the database using the find all   method which is provided by the spring data jpa
        Page<Post>  posts = postRepository.findAll(pageable);
        // get content from the page
        List<Post> postList = posts.getContent();
        return postList.stream().map(this::MapToDto).collect(Collectors.toList());


    }

    // gte post by id
    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post ", id, id));
        return MapToDto(post);

    }

    // update post by id
    @Override
    public PostDto updatePostById(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post ", id, id));
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        Post updatedPost = postRepository.save(post);
        return MapToDto(updatedPost);
    }


    // delete post by id
    @Override
    public PostDto deletePostById(Long id) {
        Post p = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post ", id, id));
        if (p != null) {
            postRepository.delete(p);

        }
        return MapToDto(p);


    }


}
