package com.example.Blogapplication.model;


import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime createdAt;

}
