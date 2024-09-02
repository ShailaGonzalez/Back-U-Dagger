package com.skate.skate;

import com.skate.skate.model.Product;
import com.skate.skate.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    void testCreateAndRetrieveProduct() {
        Product product = new Product();
        product.setName("IntegrationTestProduct");
        product.setPrice(99.99);

        ResponseEntity<Product> createResponse = productService.createProduct(product);
        assertEquals(201, createResponse.getStatusCode().value());  // HTTP 201 Created

        Product createdProduct = createResponse.getBody();
        assertNotNull(createdProduct);

        ResponseEntity<Product> retrieveResponse = productService.getProductById(createdProduct.getId());
        Product retrievedProduct = retrieveResponse.getBody();

        assertNotNull(retrievedProduct);
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getPrice(), retrievedProduct.getPrice());
    }
}
