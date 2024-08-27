package com.skate.skate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.skate.skate.models.Products;
import com.skate.skate.services.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Products product) {
        return productsService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
        return productsService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer id, @RequestBody Products product) {
        return productsService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
        return productsService.deleteProduct(id);
    }
}
