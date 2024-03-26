package com.blog.service.impl;

import com.blog.entity.Post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.PostDto;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepo ;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
        //constructor based dependancy injection
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepo.save(post);
        PostDto dto = new PostDto();
        dto.setId(savedPost.getId());
        dto.setTitle(savedPost.getTitle());
        dto.setContent(savedPost.getContent());
        dto.setDescription(savedPost.getDescription());
        dto.setMessage("Post is created ");
        return dto ;
    }

    @Override
    public void deletePost(long id) {
//        Optional<Post> byId = postRepo.findById(id);
//        if (byId.isPresent()) {
//            postRepo.deleteById(id);
//        } else {
//            throw new ResourceNotFoundException("Post Not found with id" + id);
//        }
//       Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("post not Found id-"+id));

        Post post = postRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id "+id)
        );
        System.out.println(post);


        postRepo.deleteById(id);


    }

    @Override
    public List<PostDto> getPost() {
        return null;
    }

    @Override
    public List<PostDto> getPost(int pageNo , int pageSize , String sortBy , String sortDer) {

        Pageable pageable = PageRequest.of(pageNo , pageSize , sortDer.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending());
        Page<Post> pagepost = postRepo.findAll(pageable);
        List<Post> posts = pagepost.getContent();
//        List<Post> posts = postRepo.findAll();
        List<PostDto> collect = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());


        return collect;
    }

    @Override
    public PostDto updatePost(long postId, PostDto postDto) {
         Post post = postRepo.findById(postId).orElseThrow(
                 ()->new ResourceNotFoundException("Post id is not found "+postId)
         );
         post.setTitle(postDto.getTitle());
         post.setContent(postDto.getContent());
         post.setDescription(postDto.getDescription());
        Post save = postRepo.save(post);
        PostDto postDto1 = mapToDto(save);
        return postDto1 ;


    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto() ;
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        return dto;
    }
}
