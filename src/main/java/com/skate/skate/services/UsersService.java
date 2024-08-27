package com.skate.skate.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skate.skate.models.Users;
import com.skate.skate.repositories.UsersRepository; 


@Service
public class UsersService {
    

    private final UsersRepository usersRepository;


    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers(){
        return usersRepository.findAll();
        }


     public ResponseEntity<Object> addUsers(Users users){
        usersRepository.save(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
        }







}

