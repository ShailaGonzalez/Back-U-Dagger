package com.skate.skate.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.skate.skate.models.Skateparks;
import com.skate.skate.repositories.SkateparksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkateparksService {

    private final SkateparksRepository skateparksRepository;

    public SkateparksService(SkateparksRepository skateparksRepository) {
        this.skateparksRepository = skateparksRepository;
    }

    // Obtener todos los skateparks
    public List<Skateparks> getAllSkateparks() {
        return skateparksRepository.findAll();
    }

    // Agregar un nuevo skatepark
    public ResponseEntity<Object> createSkatepark(Skateparks skatepark) {
        skateparksRepository.save(skatepark);
        return new ResponseEntity<>(skatepark, HttpStatus.CREATED);
    }

    // Obtener un skatepark por ID
    public ResponseEntity<Object> getSkateparkById(Integer id) {
        Optional<Skateparks> skatepark = skateparksRepository.findById(id);
        if (skatepark.isPresent()) {
            return new ResponseEntity<>(skatepark.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skatepark not found", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un skatepark existente
    public ResponseEntity<Object> updateSkatepark(Integer id, Skateparks updatedSkatepark) {
        Optional<Skateparks> existingSkatepark = skateparksRepository.findById(id);
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
        Optional<Skateparks> skatepark = skateparksRepository.findById(id);
        if (skatepark.isPresent()) {
            skateparksRepository.deleteById(id);
            return new ResponseEntity<>("Skatepark deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Skatepark not found", HttpStatus.NOT_FOUND);
        }
    }
}
