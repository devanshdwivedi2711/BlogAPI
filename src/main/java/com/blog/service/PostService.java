package com.blog.service;

import com.blog.entity.Post;
import com.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(long id);

    public List<PostDto> getPost();

    List<PostDto> getPost(int pageNo, int pageSize , String sortBy ,String sortDer);

    PostDto updatePost(long postId, PostDto postDto);
}
