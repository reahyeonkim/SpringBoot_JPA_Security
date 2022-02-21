package com.web.blog.repository;

import com.web.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//DAO
//자동으로 bean등록
//@Repository //생략가능
public interface UserRepository extends JpaRepository<User,Integer> {
    //SELECT * FROM user WHERE  username =1?
    Optional<User>findByUsername(String username);

}



// JPA Naming 쿼리
// SELECT * FROM user WHERE username = ?1 AND password = ?2;
//User findByUsernameAndPassword(String username, String password);

//	@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	User login(String username, String password);
