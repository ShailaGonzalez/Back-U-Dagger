package com.skate.skate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.skate.model.Skatepark;

public interface SkateparkRepository extends JpaRepository<Skatepark, Integer> {
}
