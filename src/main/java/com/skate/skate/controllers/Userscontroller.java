package com.skate.skate.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.skate.skate.models.Users;
import com.skate.skate.services.UsersService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Userscontroller {

    private final UsersService usersService;

    public Userscontroller(UsersService usersService) {
        this.usersService = usersService;

    }

    @GetMapping("/users") /// hacer el get en postman
    public List<Users> getUsers() {
        return usersService.getUsers();
    }

    @PostMapping("/users") /// hacer el post en postman y comprobarlo en pgadmin
    public ResponseEntity<Object> addUsers(@RequestBody Users users) {
        return usersService.addUsers(users);
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody Users updatedUser) {
        return usersService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        return usersService.deleteUser(id);
    }
}