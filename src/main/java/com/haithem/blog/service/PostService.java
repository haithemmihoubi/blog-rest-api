package com.haithem.blog.service;

import com.haithem.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts(int pageNo, int pageSize);
 // get post by id
    PostDto getPostById(Long id);

     PostDto updatePostById(Long id , PostDto postDto) ;
     PostDto deletePostById(Long id) ;

}
