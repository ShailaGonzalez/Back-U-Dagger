package com.skate.skate.service;

import com.skate.skate.model.User;
import com.skate.skate.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Preparar datos
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user1");
        user1.setPassword("password1");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");
        user2.setPassword("password2");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Ejecutar el servicio
        var users = userService.getAllUsers();

        // Verificar resultados
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getUsername());
    }

    @Test
    void testCreateUser() {
        // Preparar datos
        User user = new User();
        user.setId(1);
        user.setUsername("user1");
        user.setPassword("password1");

        when(userRepository.save(any(User.class))).thenReturn(user);

        // Ejecutar el servicio
        ResponseEntity<User> response = userService.createUser(user);

        // Verificar resultados
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetUserById() {
        // Preparar datos
        User user = new User();
        user.setId(1);
        user.setUsername("user1");
        user.setPassword("password1");

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        // Ejecutar el servicio
        ResponseEntity<User> response = userService.getUserById(1);

        // Verificar resultados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testUpdateUser() {
        // Preparar datos
        User existingUser = new User();
        existingUser.setId(1);
        existingUser.setUsername("user1");
        existingUser.setPassword("password1");

        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setUsername("updatedUser");
        updatedUser.setPassword("updatedPassword");

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        // Ejecutar el servicio
        ResponseEntity<User> response = userService.updateUser(1, updatedUser);

        // Verificar resultados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());
    }

    @Test
    void testDeleteUser() {
        // Preparar datos
        User user = new User();
        user.setId(1);
        user.setUsername("user1");
        user.setPassword("password1");

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        // Ejecutar el servicio
        ResponseEntity<String> response = userService.deleteUser(1);

        // Verificar resultados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User deleted successfully", response.getBody());
    }
}
