package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

}
