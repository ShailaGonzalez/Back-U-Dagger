package com.skate.skate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skate.skate.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
