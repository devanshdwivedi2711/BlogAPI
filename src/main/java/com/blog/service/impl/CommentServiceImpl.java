package com.blog.service.impl;

import com.blog.entity.Comments;
import com.blog.entity.Post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.CommentDto;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;
import com.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository comRepo ;
    private PostRepository postRepo;

    public CommentServiceImpl(CommentRepository comRepo , PostRepository postRepo) {
        this.comRepo = comRepo;
        this.postRepo = postRepo ;
    }

    @Override
    public CommentDto createComments(Long postId, CommentDto dto) {
        Post post  = postRepo.findById(postId).orElseThrow(
                ()->new ResourceNotFoundException("Post is not found ")
        );
        Comments com = new Comments() ;
        com.setPost(post);
        com.setEmail(dto.getEmail());
        com.setName(dto.getName());
        com.setBody(dto.getBody());
        Comments saved = comRepo.save(com);
        CommentDto commentDto = new CommentDto() ;
        commentDto.setName(saved.getName());
        commentDto.setEmail(saved.getEmail());
        commentDto.setBody(saved.getBody());
        commentDto.setId(saved.getId());
        return commentDto ;


    }

    @Override
    public List<CommentDto> getComments(Long postId) {
        List<Comments> byPostId = comRepo.findByPostId(postId);
        List<CommentDto> dto = byPostId.stream().map(p -> MapToCommentsDto(p)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public void deleteComment(long comId) {


        Optional<Comments> byId = comRepo.findById(comId);
        //System.out.println(comments);
//        if(byId.isPresent()){
//            System.out.println(byId.get());
//        }
//        else {
//            System.out.println("null");
//
//        }
        comRepo.deleteById(comId);




    }

    CommentDto MapToCommentsDto(Comments com){
        CommentDto dto = new CommentDto();
        dto.setId(com.getId());
        dto.setName(com.getName());
        dto.setBody(com.getBody());
        dto.setEmail(com.getEmail());
        return dto;
    }
}
