package com.skate.skate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.skate.models.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
    
}
