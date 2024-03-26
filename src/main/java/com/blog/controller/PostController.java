package com.blog.controller;

import com.blog.payload.PostDto;
import com.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postSer ;

    public PostController(PostService postSer) {
        this.postSer = postSer;
    }

    @PostMapping
    //Request body  will copy all the data from JSON to post Dto only one condition  varible name should be the same
    public ResponseEntity<?> createPost(@Valid  @RequestBody PostDto postDto , BindingResult bindingResult){
         // when the error occurs it bind the error and store the error it can tackel by our self using Response Entity
       if(bindingResult.hasErrors()){
           return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        // integer is returning and down side its returning in string for that return type
           // u can use Objct genirics or ?
       }

        PostDto dto = postSer.createPost(postDto);
        return new ResponseEntity<>(dto , HttpStatus.CREATED);
          //using response Entity class we can share information to Post man
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id ){
        postSer.deletePost(id);
        return new ResponseEntity<>("Post is deleted", HttpStatus.OK);
    }
      //http//localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title&sortDer=Asc
      @GetMapping
     public ResponseEntity<List<PostDto>> getAllPosts(
             @RequestParam(name="pageNo",defaultValue = "0",required = false) int pageNo ,
             @RequestParam(name="pageSize",defaultValue = "3",required = false) int pageSize,
             @RequestParam(name="sortby" , defaultValue = "Id" , required = false) String sortBy,
             @RequestParam(name="sortDer" , defaultValue = "asc") String sortDer

      ){
          List<PostDto> postDto= postSer.getPost(pageNo , pageSize , sortBy,sortDer);
          return new ResponseEntity<>(postDto , HttpStatus.OK);
      }

      @PutMapping
     ResponseEntity<PostDto> updatePost(@RequestParam(name="postId" ) long postId , @RequestBody PostDto postDto){
          PostDto postDto1 = postSer.updatePost(postId, postDto);
          return new ResponseEntity<>(postDto1 , HttpStatus.OK);
      }


}
