package com.skate.skate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id; 
    private String name;
    private Double price;

    // Constructor sin argumentos
    public Products() {}

    // Constructor con todos los argumentos
    public Products(Integer id, String name, Double price) { 
        this.price = price;
    }

    public Integer getId() { 
        return id;
    }

    public void setId(Integer id) { 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
