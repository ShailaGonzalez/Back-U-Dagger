package com.skate.skate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products") // Nombre de la tabla en la base de datos
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se adapta al tipo de columna id en SQL
    private Integer id;
    
    private String name;
    private Double price;

    // Relación Many-to-One con Users
    @ManyToOne
    @JoinColumn(name = "user_id") // Nombre de la columna en la tabla products
    private User user;

    // Getters y Setters
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
