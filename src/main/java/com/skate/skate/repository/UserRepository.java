package com.skate.skate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.skate.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
