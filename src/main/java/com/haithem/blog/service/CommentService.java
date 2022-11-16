package com.haithem.blog.service;

import com.haithem.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
 CommentDto createComment(Long PostID ,CommentDto commentDto);
List<CommentDto> getCommentsByPostId(Long postId);
List<CommentDto> getAllComments();
List<CommentDto> getAllCommentsByPostIdAndName(Long postId, String name);
// delete comment by id
void deleteComment(Long id);
}
