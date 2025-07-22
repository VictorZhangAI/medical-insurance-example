package main.controller;

import main.model.Medicine;
import main.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/api/medicines")
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @GetMapping("/api/medicines/{id}")
    public Medicine getMedicineById(@PathVariable("id") String medId) {
        return medicineRepository.findById(medId).orElse(null);
    }
} 