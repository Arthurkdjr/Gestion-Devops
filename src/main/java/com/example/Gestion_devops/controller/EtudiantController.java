package com.example.Gestion_devops.controller;



import com.example.Gestion_devops.model.Etudiant;
import com.example.Gestion_devops.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    // Récupérer tous les étudiants
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // Récupérer un étudiant par son ID
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    // Créer un nouvel étudiant
    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Mettre à jour un étudiant existant
    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setEmail(etudiantDetails.getEmail());
        return etudiantRepository.save(etudiant);
    }

    // Supprimer un étudiant
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantRepository.deleteById(id);
    }
}