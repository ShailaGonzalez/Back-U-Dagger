package com.skate.skate.service;

import com.skate.skate.model.Skatepark;
import com.skate.skate.repository.SkateparkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateparkService {

    private final SkateparkRepository skateparkRepository;

    public SkateparkService(SkateparkRepository skateparkRepository) {
        this.skateparkRepository = skateparkRepository;
    }

    public ResponseEntity<List<Skatepark>> getAllSkateparks() {
        List<Skatepark> skateparks = skateparkRepository.findAll();
        return new ResponseEntity<>(skateparks, HttpStatus.OK);
    }

    public ResponseEntity<Skatepark> getSkateparkById(int id) {
        Optional<Skatepark> skatepark = skateparkRepository.findById(id);
        return skatepark
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
