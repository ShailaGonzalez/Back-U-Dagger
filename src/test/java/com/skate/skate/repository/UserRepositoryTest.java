package com.skate.skate.repository;

import com.skate.skate.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        // Crear un nuevo usuario
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        // Guardar el usuario en la base de datos
        User savedUser = userRepository.save(user);

        // Recuperar el usuario por su ID
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        // Verificar que el usuario no sea nulo
        assertNotNull(foundUser, "User should not be null");

        // Verificar que los atributos del usuario coincidan
        assertEquals(savedUser.getUsername(), foundUser.getUsername(), "Usernames should match");
        assertEquals(savedUser.getPassword(), foundUser.getPassword(), "Passwords should match");
    }
}
