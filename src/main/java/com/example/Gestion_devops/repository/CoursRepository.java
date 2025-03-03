package com.example.Gestion_devops.repository;




import com.example.Gestion_devops.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}