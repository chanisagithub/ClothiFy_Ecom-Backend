package com.example.clothifyecom.repository;

import com.example.clothifyecom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    User findByUserID(int userID);



}
