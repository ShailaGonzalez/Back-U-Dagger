package com.skate.skate.controller;

import com.skate.skate.model.Skatepark;
import com.skate.skate.service.SkateparkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skateparks")
public class SkateparkController {

    private final SkateparkService skateparkService;

    public SkateparkController(SkateparkService skateparkService) {
        this.skateparkService = skateparkService;
    }

    @GetMapping
    public ResponseEntity<List<Skatepark>> getAllSkateparks() {
        return skateparkService.getAllSkateparks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skatepark> getSkateparkById(@PathVariable int id) {
        return skateparkService.getSkateparkById(id);
    }
}
