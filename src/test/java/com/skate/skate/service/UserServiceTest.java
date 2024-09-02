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
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user1");
        user1.setPassword("password1");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");
        user2.setPassword("password2");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        var users = userService.getAllUsers();

        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getUsername());
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("user1");
        user.setPassword("password1");

        when(userRepository.save(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userService.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1);
        user.setUsername("user1");
        user.setPassword("password1");

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userService.getUserById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(1);
        existingUser.setUsername("user1");
        existingUser.setPassword("password1");

        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setUsername("updatedUser");
        updatedUser.setPassword("updatedPassword");

        when(userRepository.existsById(anyInt())).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        ResponseEntity<User> response = userService.updateUser(1, updatedUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());
    }

    @Test
    void testDeleteUser() {
        when(userRepository.existsById(anyInt())).thenReturn(true);

        ResponseEntity<String> response = userService.deleteUser(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User deleted successfully", response.getBody());
    }

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        ResponseEntity<User> response = userService.getUserById(999);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testUpdateUserNotFound() {
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setUsername("updatedUser");
        updatedUser.setPassword("updatedPassword");

        when(userRepository.existsById(anyInt())).thenReturn(false);

        ResponseEntity<User> response = userService.updateUser(1, updatedUser);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
