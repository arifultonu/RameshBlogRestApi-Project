package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (
    name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)

public class Post{

    @Id
    @Column(name = "id")
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
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

}
