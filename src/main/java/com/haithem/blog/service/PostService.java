package com.haithem.blog.service;

import com.haithem.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts() ;
 // get post by id
    PostDto getPostById(Long id);


     PostDto updatePostById(Long id , PostDto postDto) ;

}
