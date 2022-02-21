package com.web.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Builder
// User 클래스가 MariaDB 에 테이블이 생성이 된다.
// @DynamicInsert // insert시에 null인 필드를 제외시켜준다.
@Entity
public class User {

        @Id //Primary key
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private int id;

        @Column(nullable = false,length = 30 ,unique = true)
        private String username;

        @Column(nullable = false,length = 100)
        private String password;

        @Column(nullable = false,length = 50)
        private String email;


        @Enumerated(EnumType.STRING)
        private RoleType role;  // Enum을 쓰는게 좋음. // ADMIN, USER

        private String oauth;

        @CreationTimestamp
        private Timestamp createDate;

    }

