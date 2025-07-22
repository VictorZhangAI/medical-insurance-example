package main.repository;

import main.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
    List<Medicine> findByMedNameContaining(String medName);
    List<Medicine> findByMedIdContaining(String medId);
    List<Medicine> findByMedNameContainingAndMedIdContaining(String medName, String medId);
} 