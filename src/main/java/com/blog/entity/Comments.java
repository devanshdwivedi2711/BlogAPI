package com.blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Table(name="comments")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private  String body ;
    private String name ;
    private  String email ;


    @ManyToOne

    @JoinColumn(name="post_id" )
    private Post post   ;

//    public long getId() {
//        return id;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
