package com.skate.skate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skate.skate.model.Product;
import com.skate.skate.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productsService;

    public ProductController(ProductService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        return productsService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
        return productsService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productsService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
        return productsService.deleteProduct(id);
    }
}
