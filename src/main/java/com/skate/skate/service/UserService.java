package com.skate.skate.service;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skate.skate.model.User;
import com.skate.skate.repository.UserRepository; 


@Service
public class UserService {
    

    private final UserRepository usersRepository;


    public UserService(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }


       // Obtener todos los usuarios
    public List<User> getUsers(){
        return usersRepository.findAll();
        }


        // Agregar un nuevo usuario
     public ResponseEntity<Object> addUsers(User users){
        usersRepository.save(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
        }


         // Obtener un usuario por ID
    public ResponseEntity<Object> getUserById(Integer id) {
        Optional<User> user = usersRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un usuario existente
    public ResponseEntity<Object> updateUser(Integer id, User updatedUser) {
        Optional<User> existingUser = usersRepository.findById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id); // Asegurarse de que el ID no cambie
            usersRepository.save(updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un usuario
    public ResponseEntity<Object> deleteUser(Integer id) {
        Optional<User> user = usersRepository.findById(id);
        if (user.isPresent()) {
            usersRepository.deleteById(id);
            return new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}






