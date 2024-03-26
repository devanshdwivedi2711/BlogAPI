package com.blog.controller;

import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private  CommentService commentService  ;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createCommetsP(@RequestParam(name="postId" ,required = true ) long postId ,
                                                     @RequestBody CommentDto dto){
        CommentDto comments = commentService.createComments(postId, dto);

        return  new ResponseEntity<>(comments , HttpStatus.CREATED) ;
    }
    @GetMapping

    public ResponseEntity<List<CommentDto>> getComment
            (@RequestParam(name="postId" , required = false ) long postId){
        List<CommentDto> comments = commentService.getComments(postId);
        return new ResponseEntity<>(comments , HttpStatus.OK);

    }
    @DeleteMapping
    public ResponseEntity<String> deleteComments( @RequestParam(name="comId") long id  ){
        commentService.deleteComment( id);
        return new ResponseEntity<>("post is delted", HttpStatus.OK);
    }
}
