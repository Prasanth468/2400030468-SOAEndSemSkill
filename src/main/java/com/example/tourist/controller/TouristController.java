package com.example.tourist.controller;

import com.example.tourist.entity.Tourist;
import com.example.tourist.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<Tourist>> getAllTourists() {
        return ResponseEntity.ok(touristService.getAllTourists());
    }
}
