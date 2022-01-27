package com.springboot.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

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
    private long id;

    @Column(length = 60)
    private String name;
}
