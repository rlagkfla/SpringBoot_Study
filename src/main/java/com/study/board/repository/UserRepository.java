package com.study.board.repository;

import com.study.board.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    /* OAuth */
    Optional<Users> findByEmail(String email);

}
