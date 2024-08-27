package com.skate.skate.services;

import java.util.List;
import java.util.Optional;


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


       // Obtener todos los usuarios
    public List<Users> getUsers(){
        return usersRepository.findAll();
        }


        // Agregar un nuevo usuario
     public ResponseEntity<Object> addUsers(Users users){
        usersRepository.save(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
        }


         // Obtener un usuario por ID
    public ResponseEntity<Object> getUserById(Integer id) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un usuario existente
    public ResponseEntity<Object> updateUser(Integer id, Users updatedUser) {
        Optional<Users> existingUser = usersRepository.findById(id);
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
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            usersRepository.deleteById(id);
            return new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}






