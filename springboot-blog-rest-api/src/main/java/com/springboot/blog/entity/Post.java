package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table (
    name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post{

    @Id
    @SequenceGenerator(
            name = "post_id_gen",
            sequenceName = "post_id_gen",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id_gen"
    )
    private Long id;

    @Column(
            name = "title", nullable = false
    )
    private String title;

    @Column(
            name = "description", nullable = false
    )
    private String description;

    @Column(
            name = "content", nullable = false
    )
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Post addComment(Comment comment)
    {
        comments.add(comment);
        comment.setPost(this);
        return this;
    }

    public Post removeComment(Comment comment)
    {
        comments.remove(comment);
        comment.setPost(null);
        return this;
    }

//    public Vendor removeClient(Client client)
//    {
//        clients.remove(client);
//        clients.setVendor(null);
//        return this;
//    }


}
