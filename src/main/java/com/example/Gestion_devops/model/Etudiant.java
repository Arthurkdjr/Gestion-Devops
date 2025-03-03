package com.example.Gestion_devops.model;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
}
