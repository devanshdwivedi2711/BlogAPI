package com.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
 @Table(name="posts")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private  String title ;

    private String description ;
    private String content ;


  @OneToMany (mappedBy = "post",cascade = CascadeType.ALL , orphanRemoval = true)

    private List<Comments> coments = new ArrayList<>();

}
/* lambok is devtools which provides the auto mated getter setters by using @DAta annotation and
constructor by using NoArgsConstructior annotation and Args constructor
* */
