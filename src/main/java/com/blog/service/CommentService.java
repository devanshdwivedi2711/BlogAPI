package com.blog.service;

import com.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto createComments(Long postId , CommentDto dto);
    public List<CommentDto> getComments(Long postId );

    void deleteComment(long postId);
}
