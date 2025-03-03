package com.example.Gestion_devops.repository;



import com.example.Gestion_devops.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
