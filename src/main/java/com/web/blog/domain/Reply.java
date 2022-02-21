package com.web.blog.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name="boardId") // FK 로 씀
    private Board board;

    @ManyToOne
    @JoinColumn(name="userId")
    private  User user;

    @CreationTimestamp
    private LocalDateTime createDate;


}
