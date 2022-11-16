package com.haithem.blog.repository;

import com.haithem.blog.entity.Comment;
import com.haithem.blog.payload.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findAllByPostId(Long postId);


    Collection<CommentDto> findAllByPostIdAndName(Long postId, String name);
}
