package com.skate.skate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skate.skate.models.Skateparks;

public interface SkateparksRepository extends JpaRepository<Skateparks, Integer> {
}
