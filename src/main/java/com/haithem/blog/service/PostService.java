package com.haithem.blog.service;

import com.haithem.blog.payload.PostDto;
import com.haithem.blog.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);
   PostResponse getAllPosts(int pageNo, int pageSize,String sortBy);
 // get post by id
    PostDto getPostById(Long id);

     PostDto updatePostById(Long id , PostDto postDto) ;
     PostDto deletePostById(Long id) ;

}
