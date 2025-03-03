package com.example.Gestion_devops.controller;



import com.example.Gestion_devops.model.Classe;
import com.example.Gestion_devops.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClasseController {
    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe) {
        return classeRepository.save(classe);
    }
}