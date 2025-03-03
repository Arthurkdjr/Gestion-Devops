package com.example.Gestion_devops.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EmploiDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private String heureDebut;
    private String heureFin;
    private Long classeId;
    private Long coursId;
}