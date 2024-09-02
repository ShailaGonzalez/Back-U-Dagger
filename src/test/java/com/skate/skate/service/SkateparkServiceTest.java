package com.skate.skate.service;

import com.skate.skate.model.Skatepark;
import com.skate.skate.repository.SkateparkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class SkateparkServiceTest {

    @Mock
    private SkateparkRepository skateparkRepository;

    @InjectMocks
    private SkateparkService skateparkService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSkateparks() {
        Skatepark skatepark1 = new Skatepark();
        skatepark1.setId(1);
        skatepark1.setName("Skatepark1");
        skatepark1.setLocation("Location1");

        Skatepark skatepark2 = new Skatepark();
        skatepark2.setId(2);
        skatepark2.setName("Skatepark2");
        skatepark2.setLocation("Location2");

        when(skateparkRepository.findAll()).thenReturn(Arrays.asList(skatepark1, skatepark2));

        var skateparks = skateparkService.getAllSkateparks();

        assertEquals(2, skateparks.size());
        assertEquals("Skatepark1", skateparks.get(0).getName());
    }

    @Test
    void testCreateSkatepark() {
        Skatepark skatepark = new Skatepark();
        skatepark.setId(1);
        skatepark.setName("Skatepark1");
        skatepark.setLocation("Location1");

        when(skateparkRepository.save(any(Skatepark.class))).thenReturn(skatepark);

        ResponseEntity<Object> response = skateparkService.createSkatepark(skatepark);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(skatepark, response.getBody());
    }

    @Test
    void testGetSkateparkById() {
        Skatepark skatepark = new Skatepark();
        skatepark.setId(1);
        skatepark.setName("Skatepark1");
        skatepark.setLocation("Location1");

        when(skateparkRepository.findById(anyInt())).thenReturn(Optional.of(skatepark));

        ResponseEntity<Object> response = skateparkService.getSkateparkById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(skatepark, response.getBody());
    }
}
