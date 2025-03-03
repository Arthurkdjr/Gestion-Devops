package com.example.Gestion_devops.repository;



import com.example.Gestion_devops.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}