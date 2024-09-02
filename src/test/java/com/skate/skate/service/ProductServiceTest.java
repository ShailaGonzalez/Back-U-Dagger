package com.skate.skate.service;

import com.skate.skate.model.Product;
import com.skate.skate.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;  // Mock del repositorio

    @InjectMocks
    private ProductService productService;  // Servicio que será probado

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks antes de cada prueba
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(20.00);

        // Configura el mock para que devuelva el producto al guardarlo
        when(productRepository.save(product)).thenReturn(product);

        // Llama al método que queremos probar
        ResponseEntity<Product> response = productService.createProduct(product);

        // Verifica que el código de estado y el contenido sean los esperados
        assertEquals(201, response.getStatusCode().value());  // HTTP 201 Created
        Product responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("TestProduct", responseBody.getName());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1);  // Asegúrate de que el ID es Integer
        product.setName("TestProduct");
        product.setPrice(20.00);

        // Configura el mock para que devuelva el producto al buscar por ID
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Llama al método que queremos probar
        ResponseEntity<Product> response = productService.getProductById(1);

        // Verifica que el código de estado y el contenido sean los esperados
        assertEquals(200, response.getStatusCode().value());  // HTTP 200 OK
        Product responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("TestProduct", responseBody.getName());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setId(1);  // Asegúrate de que el ID es Integer
        product.setName("TestProduct");
        product.setPrice(20.00);

        // Configura el mock para que devuelva el producto al buscar y guardar
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        // Actualiza el nombre del producto
        product.setName("UpdatedProduct");
        ResponseEntity<Product> response = productService.updateProduct(1, product);

        // Verifica que el código de estado y el contenido sean los esperados
        assertEquals(200, response.getStatusCode().value());  // HTTP 200 OK
        Product responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("UpdatedProduct", responseBody.getName());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setId(1);  // Asegúrate de que el ID es Integer
        product.setName("TestProduct");
        product.setPrice(20.00);

        // Configura el mock para que devuelva el producto al buscar por ID
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Llama al método que queremos probar
        ResponseEntity<String> response = productService.deleteProduct(1);

        // Verifica que el código de estado y el contenido sean los esperados
        assertEquals(200, response.getStatusCode().value());  // HTTP 200 OK
        String responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("Product deleted successfully", responseBody);
    }
}
