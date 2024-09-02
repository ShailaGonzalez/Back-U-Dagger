package com.skate.skate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skate.skate.model.Skatepark;
import com.skate.skate.service.SkateparkService;

import java.util.List;

@RestController
@RequestMapping("/skateparks")
public class SkateparkController {

    private final SkateparkService skateparksService;

    public SkateparkController(SkateparkService skateparksService) {
        this.skateparksService = skateparksService;
    }

    @GetMapping
    public List<Skatepark> getAllSkateparks() {
        return skateparksService.getAllSkateparks();
    }

    @PostMapping
    public ResponseEntity<Object> createSkatepark(@RequestBody Skatepark skatepark) {
        return skateparksService.createSkatepark(skatepark);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSkateparkById(@PathVariable Integer id) {
        return skateparksService.getSkateparkById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSkatepark(@PathVariable Integer id, @RequestBody Skatepark skatepark) {
        return skateparksService.updateSkatepark(id, skatepark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSkatepark(@PathVariable Integer id) {
        return skateparksService.deleteSkatepark(id);
    }
}
