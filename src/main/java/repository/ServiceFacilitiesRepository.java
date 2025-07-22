package main.repository;

import main.model.ServiceFacilities;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceFacilitiesRepository extends JpaRepository<ServiceFacilities, String> {
    List<ServiceFacilities> findBySerNameContaining(String serName);
    List<ServiceFacilities> findBySerIdContaining(String serId);
    List<ServiceFacilities> findBySerNameContainingAndSerIdContaining(String serName, String serId);
} 