package main.controller;

import main.model.ServiceFacilities;
import main.repository.ServiceFacilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ServiceFacilitiesController {
    @Autowired
    private ServiceFacilitiesRepository serviceFacilitiesRepository;

    @GetMapping("/api/service-facilities")
    public List<ServiceFacilities> getAll(
        @RequestParam(value = "serName", required = false) String serName,
        @RequestParam(value = "serID", required = false) String serID
    ) {
        if ((serName == null || serName.isEmpty()) && (serID == null || serID.isEmpty())) {
            return serviceFacilitiesRepository.findAll();
        } else if (serName != null && !serName.isEmpty() && (serID == null || serID.isEmpty())) {
            return serviceFacilitiesRepository.findBySerNameContaining(serName);
        } else if ((serName == null || serName.isEmpty()) && serID != null && !serID.isEmpty()) {
            return serviceFacilitiesRepository.findBySerIdContaining(serID);
        } else {
            return serviceFacilitiesRepository.findBySerNameContainingAndSerIdContaining(serName, serID);
        }
    }

    @GetMapping("/api/service-facilities/{id}")
    public ServiceFacilities getById(@PathVariable("id") String serId) {
        return serviceFacilitiesRepository.findById(serId).orElse(null);
    }

    @PostMapping("/api/service-facilities")
    public ServiceFacilities add(@RequestBody Map<String, Object> params) throws ParseException {
        ServiceFacilities s = new ServiceFacilities();
        s.setSerId((String) params.get("serID"));
        s.setSerName((String) params.get("serName"));
        s.setSerExpType((String) params.get("serExpType"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (params.get("serStarttime") != null && !params.get("serStarttime").toString().isEmpty()) {
            s.setSerStarttime(sdf.parse((String) params.get("serStarttime")));
        }
        if (params.get("serEndtime") != null && !params.get("serEndtime").toString().isEmpty()) {
            s.setSerEndtime(sdf.parse((String) params.get("serEndtime")));
        }
        s.setSerValid("1".equals(params.get("serValid")) || "有效".equals(params.get("serValid")));
        return serviceFacilitiesRepository.save(s);
    }

    @PutMapping("/api/service-facilities/{id}")
    public ServiceFacilities update(@PathVariable("id") String serId, @RequestBody Map<String, Object> params) throws ParseException {
        ServiceFacilities s = serviceFacilitiesRepository.findById(serId).orElse(null);
        if (s == null) return null;
        s.setSerName((String) params.get("serName"));
        s.setSerExpType((String) params.get("serExpType"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (params.get("serStarttime") != null && !params.get("serStarttime").toString().isEmpty()) {
            s.setSerStarttime(sdf.parse((String) params.get("serStarttime")));
        } else {
            s.setSerStarttime(null);
        }
        if (params.get("serEndtime") != null && !params.get("serEndtime").toString().isEmpty()) {
            s.setSerEndtime(sdf.parse((String) params.get("serEndtime")));
        } else {
            s.setSerEndtime(null);
        }
        s.setSerValid("1".equals(params.get("serValid")) || "有效".equals(params.get("serValid")));
        return serviceFacilitiesRepository.save(s);
    }

    @DeleteMapping("/api/service-facilities/{id}")
    public void delete(@PathVariable("id") String serId) {
        serviceFacilitiesRepository.deleteById(serId);
    }
} 