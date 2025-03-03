package com.example.Gestion_devops.controller;



import com.example.Gestion_devops.model.EmploiDuTemps;
import com.example.Gestion_devops.repository.EmploiDuTempsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplois-du-temps")
public class EmploiDuTempsController {

    @Autowired
    private EmploiDuTempsRepository emploiDuTempsRepository;

    // Récupérer tous les emplois du temps
    @GetMapping
    public List<EmploiDuTemps> getAllEmploisDuTemps() {
        return emploiDuTempsRepository.findAll();
    }

    // Récupérer un emploi du temps par son ID
    @GetMapping("/{id}")
    public EmploiDuTemps getEmploiDuTempsById(@PathVariable Long id) {
        return emploiDuTempsRepository.findById(id).orElseThrow(() -> new RuntimeException("Emploi du temps non trouvé"));
    }

    // Créer un nouvel emploi du temps
    @PostMapping
    public EmploiDuTemps createEmploiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps) {
        return emploiDuTempsRepository.save(emploiDuTemps);
    }

    // Mettre à jour un emploi du temps existant
    @PutMapping("/{id}")
    public EmploiDuTemps updateEmploiDuTemps(@PathVariable Long id, @RequestBody EmploiDuTemps emploiDuTempsDetails) {
        EmploiDuTemps emploiDuTemps = emploiDuTempsRepository.findById(id).orElseThrow(() -> new RuntimeException("Emploi du temps non trouvé"));
        emploiDuTemps.setJour(emploiDuTempsDetails.getJour());
        emploiDuTemps.setHeureDebut(emploiDuTempsDetails.getHeureDebut());
        emploiDuTemps.setHeureFin(emploiDuTempsDetails.getHeureFin());
        emploiDuTemps.setClasseId(emploiDuTempsDetails.getClasseId());
        emploiDuTemps.setCoursId(emploiDuTempsDetails.getCoursId());
        return emploiDuTempsRepository.save(emploiDuTemps);
    }

    // Supprimer un emploi du temps
    @DeleteMapping("/{id}")
    public void deleteEmploiDuTemps(@PathVariable Long id) {
        emploiDuTempsRepository.deleteById(id);
    }
}
