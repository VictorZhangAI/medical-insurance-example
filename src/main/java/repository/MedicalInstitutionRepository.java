package main.repository;

import main.model.MedicalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicalInstitutionRepository extends JpaRepository<MedicalInstitution, String> {
    List<MedicalInstitution> findByDiaNameContaining(String diaName);
    List<MedicalInstitution> findByDiaIdContaining(String diaId);
    List<MedicalInstitution> findByDiaNameContainingAndDiaIdContaining(String diaName, String diaId);
} 