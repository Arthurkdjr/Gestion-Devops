package com.example.Gestion_devops.controller;



import com.example.Gestion_devops.model.Cours;
import com.example.Gestion_devops.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    private CoursRepository coursRepository;

    @GetMapping
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursRepository.save(cours);
    }
}
