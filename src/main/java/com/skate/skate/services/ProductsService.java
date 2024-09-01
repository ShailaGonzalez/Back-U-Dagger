package com.skate.skate.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.skate.skate.models.Products;
import com.skate.skate.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // Obtener todos los productos
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    // Agregar un nuevo producto
    public ResponseEntity<Object> createProduct(Products product) {
        productsRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // Obtener un producto por ID
    public ResponseEntity<Object> getProductById(Integer id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un producto existente
    public ResponseEntity<Object> updateProduct(Integer id, Products updatedProduct) {
        Optional<Products> existingProduct = productsRepository.findById(id);
        if (existingProduct.isPresent()) {
            updatedProduct.setId(id);
            productsRepository.save(updatedProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un producto
    public ResponseEntity<Object> deleteProduct(Integer id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            productsRepository.deleteById(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
