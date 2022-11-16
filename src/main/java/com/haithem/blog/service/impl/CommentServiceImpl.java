package com.haithem.blog.service.impl;

import com.haithem.blog.entity.Comment;
import com.haithem.blog.entity.Post;
import com.haithem.blog.exception.ResourceNotFoundException;
import com.haithem.blog.payload.CommentDto;
import com.haithem.blog.repository.CommentRepository;
import com.haithem.blog.repository.PostRepository;
import com.haithem.blog.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

private CommentRepository commentRepository;
private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(Long PostID, CommentDto commentDto) {
    //retrieve the post  from the database by its id
        Post post = postRepository.findById(PostID).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + PostID));
        //create a new comment
        Comment comment = mapToComment(commentDto);
        comment.setPost(post);
        //save the comment to the database
       Comment newComment= commentRepository.save(comment);
        //return the commentDto
        return mapToDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        //retrieve the post  from the database by its id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        //convert the list of comments to a list of commentDto
        return comments.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    @Override
    public List<CommentDto> getAllComments() {
        return  commentRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllCommentsByPostIdAndName(Long postId, String name) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);

    }


// get all comments by  id













    // comment map to dto
    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    /// dto map to comment
    private Comment mapToComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }





}

