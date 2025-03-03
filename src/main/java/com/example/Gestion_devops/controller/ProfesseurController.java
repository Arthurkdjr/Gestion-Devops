package com.example.Gestion_devops.controller;



import com.example.Gestion_devops.model.Professeur;
import com.example.Gestion_devops.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurRepository professeurRepository;

    // Récupérer tous les professeurs
    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    // Récupérer un professeur par son ID
    @GetMapping("/{id}")
    public Professeur getProfesseurById(@PathVariable Long id) {
        return professeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
    }

    // Créer un nouveau professeur
    @PostMapping
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    // Mettre à jour un professeur existant
    @PutMapping("/{id}")
    public Professeur updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeurDetails) {
        Professeur professeur = professeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
        professeur.setNom(professeurDetails.getNom());
        professeur.setPrenom(professeurDetails.getPrenom());
        professeur.setSpecialite(professeurDetails.getSpecialite());
        return professeurRepository.save(professeur);
    }

    // Supprimer un professeur
    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable Long id) {
        professeurRepository.deleteById(id);
    }
}
