package com.skate.skate.controller;

import com.skate.skate.model.Skatepark;
import com.skate.skate.service.SkateparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skateparks")
public class SkateparkController {

    @Autowired
    private SkateparkService skateparkService;

    @GetMapping
    public List<Skatepark> getAllSkateparks() {
        return skateparkService.getAllSkateparks();
    }

    @PostMapping
    public ResponseEntity<Object> createSkatepark(@RequestBody Skatepark skatepark) {
        return skateparkService.createSkatepark(skatepark);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSkateparkById(@PathVariable Integer id) {
        return skateparkService.getSkateparkById(id);
    }
}
