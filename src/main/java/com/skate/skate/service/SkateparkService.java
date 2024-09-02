package com.skate.skate.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skate.skate.model.Skatepark;
import com.skate.skate.repository.SkateparkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkateparkService {

    private final SkateparkRepository skateparksRepository;

    public SkateparkService(SkateparkRepository skateparksRepository) {
        this.skateparksRepository = skateparksRepository;
    }

    // Obtener todos los skateparks
    public List<Skatepark> getAllSkateparks() {
        return skateparksRepository.findAll();
    }

    // Agregar un nuevo skatepark
    public ResponseEntity<Object> createSkatepark(Skatepark skatepark) {
        skateparksRepository.save(skatepark);
        return new ResponseEntity<>(skatepark, HttpStatus.CREATED);
    }

    // Obtener un skatepark por ID
    public ResponseEntity<Object> getSkateparkById(Integer id) {
        Optional<Skatepark> skatepark = skateparksRepository.findById(id);
        if (skatepark.isPresent()) {
            return new ResponseEntity<>(skatepark.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skatepark not found", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un skatepark existente
    public ResponseEntity<Object> updateSkatepark(Integer id, Skatepark updatedSkatepark) {
        Optional<Skatepark> existingSkatepark = skateparksRepository.findById(id);
        if (existingSkatepark.isPresent()) {
            updatedSkatepark.setId(id);
            skateparksRepository.save(updatedSkatepark);
            return new ResponseEntity<>(updatedSkatepark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skatepark not found", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un skatepark
    public ResponseEntity<Object> deleteSkatepark(Integer id) {
        Optional<Skatepark> skatepark = skateparksRepository.findById(id);
        if (skatepark.isPresent()) {
            skateparksRepository.deleteById(id);
            return new ResponseEntity<>("Skatepark deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skatepark not found", HttpStatus.NOT_FOUND);
        }
    }
}
