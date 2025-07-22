package main.repository;

import main.model.DiagnosisProject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiagnosisProjectRepository extends JpaRepository<DiagnosisProject, String> {
    List<DiagnosisProject> findByDiaNameContaining(String diaName);
    List<DiagnosisProject> findByDiaIdContaining(String diaId);
    List<DiagnosisProject> findByDiaNameContainingAndDiaIdContaining(String diaName, String diaId);
} 