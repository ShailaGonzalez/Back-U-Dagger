package com.skate.skate.repository;

import com.skate.skate.model.Skatepark;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class SkateparkRepositoryTest {

    @Autowired
    private SkateparkRepository skateparkRepository;

    @Test
    void testSaveAndFindSkatepark() {
        Skatepark skatepark = new Skatepark();
        skatepark.setName("TestSkatepark");
        skatepark.setLocation("TestLocation");

        skateparkRepository.save(skatepark);

        Skatepark foundSkatepark = skateparkRepository.findById(skatepark.getId()).orElse(null);

        assertEquals(skatepark.getName(), foundSkatepark.getName());
        assertEquals(skatepark.getLocation(), foundSkatepark.getLocation());
    }
}
