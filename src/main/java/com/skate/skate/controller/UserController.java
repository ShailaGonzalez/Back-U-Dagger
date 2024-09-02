package com.skate.skate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.skate.skate.model.User;
import com.skate.skate.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

    private final UserService usersService;

    public UserController(UserService usersService) {
        this.usersService = usersService;

    }

    @GetMapping("/users") /// hacer el get en postman
    public List<User> getUsers() {
        return usersService.getUsers();
   }

    @PostMapping("/users") /// hacer el post en postman y comprobarlo en pgadmin
    public ResponseEntity<Object> addUsers(@RequestBody User users) {
        return usersService.addUsers(users);
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        return usersService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        return usersService.deleteUser(id);
    }
}

