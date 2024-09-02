package com.skate.skate.repository;

import com.skate.skate.model.Product;
import com.skate.skate.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindProduct() {
        // Crear y guardar un usuario
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);

        // Crear y guardar un producto asociado al usuario
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(100.0);
        product.setUser(user); // Relacionar con un usuario

        Product savedProduct = productRepository.save(product);

        // Buscar el producto guardado
        Product foundProduct = productRepository.findById(savedProduct.getId()).orElse(null);

        // Verificar que el producto no sea nulo
        assertNotNull(foundProduct);
        // Verificar las propiedades del producto
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        // Verificar la relación con el usuario
        assertEquals(product.getUser().getId(), foundProduct.getUser().getId());
    }
}
