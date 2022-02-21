package com.web.blog.repository;

import com.web.blog.domain.Board;
import com.web.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {

}
