package com.skate.skate.service;

import com.skate.skate.model.Product;
import com.skate.skate.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(20.00);

        ResponseEntity<Product> response = productService.createProduct(product);

        assertEquals(201, response.getStatusCode().value());  // HTTP 201 Created
        Product responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("TestProduct", responseBody.getName());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(20.00);
        productRepository.save(product);

        ResponseEntity<Product> response = productService.getProductById(product.getId());

        assertEquals(200, response.getStatusCode().value());  // HTTP 200 OK
        Product responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("TestProduct", responseBody.getName());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(20.00);
        productRepository.save(product);

        product.setName("UpdatedProduct");
        ResponseEntity<Product> response = productService.updateProduct(product.getId(), product);

        assertEquals(200, response.getStatusCode().value());  // HTTP 200 OK
        Product responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("UpdatedProduct", responseBody.getName());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(20.00);
        productRepository.save(product);

        ResponseEntity<String> response = productService.deleteProduct(product.getId());

        assertEquals(200, response.getStatusCode().value());  // HTTP 200 OK
        String responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("Product deleted successfully", responseBody);
    }
}
