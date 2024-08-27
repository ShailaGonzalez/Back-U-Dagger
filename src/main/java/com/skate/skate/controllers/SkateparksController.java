package com.skate.skate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.skate.skate.models.Skateparks;
import com.skate.skate.services.SkateparksService;

import java.util.List;

@RestController
@RequestMapping("/skateparks")
public class SkateparksController {

    private final SkateparksService skateparksService;

    public SkateparksController(SkateparksService skateparksService) {
        this.skateparksService = skateparksService;
    }

    @GetMapping
    public List<Skateparks> getAllSkateparks() {
        return skateparksService.getAllSkateparks();
    }

    @PostMapping
    public ResponseEntity<Object> createSkatepark(@RequestBody Skateparks skatepark) {
        return skateparksService.createSkatepark(skatepark);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSkateparkById(@PathVariable Integer id) {
        return skateparksService.getSkateparkById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSkatepark(@PathVariable Integer id, @RequestBody Skateparks skatepark) {
        return skateparksService.updateSkatepark(id, skatepark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSkatepark(@PathVariable Integer id) {
        return skateparksService.deleteSkatepark(id);
    }
}
