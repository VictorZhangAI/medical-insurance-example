package main.controller;

import main.model.MedicalInstitution;
import main.repository.MedicalInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class MedicalInstitutionController {
    @Autowired
    private MedicalInstitutionRepository medicalInstitutionRepository;

    @GetMapping("/api/medical-institutions")
    public List<MedicalInstitution> getAll(
        @RequestParam(value = "diaName", required = false) String diaName,
        @RequestParam(value = "diaID", required = false) String diaID
    ) {
        if ((diaName == null || diaName.isEmpty()) && (diaID == null || diaID.isEmpty())) {
            return medicalInstitutionRepository.findAll();
        } else if (diaName != null && !diaName.isEmpty() && (diaID == null || diaID.isEmpty())) {
            return medicalInstitutionRepository.findByDiaNameContaining(diaName);
        } else if ((diaName == null || diaName.isEmpty()) && diaID != null && !diaID.isEmpty()) {
            return medicalInstitutionRepository.findByDiaIdContaining(diaID);
        } else {
            return medicalInstitutionRepository.findByDiaNameContainingAndDiaIdContaining(diaName, diaID);
        }
    }

    @GetMapping("/api/medical-institutions/{id}")
    public MedicalInstitution getById(@PathVariable("id") String diaId) {
        return medicalInstitutionRepository.findById(diaId).orElse(null);
    }

    @PostMapping("/api/medical-institutions")
    public MedicalInstitution add(@RequestBody Map<String, Object> params) throws ParseException {
        MedicalInstitution m = new MedicalInstitution();
        m.setDiaId((String) params.get("diaID"));
        m.setDiaName((String) params.get("diaName"));
        m.setDiaExpType((String) params.get("diaExpType"));
        m.setDiaExpLevel((String) params.get("diaExpLevel"));
        Object maxPrizeObj = params.get("diaMaxPrize");
        if (maxPrizeObj != null && !maxPrizeObj.toString().isEmpty()) {
            m.setDiaMaxPrize(new BigDecimal(maxPrizeObj.toString()));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (params.get("diaStarttime") != null && !params.get("diaStarttime").toString().isEmpty()) {
            m.setDiaStarttime(sdf.parse((String) params.get("diaStarttime")));
        }
        if (params.get("diaEndtime") != null && !params.get("diaEndtime").toString().isEmpty()) {
            m.setDiaEndtime(sdf.parse((String) params.get("diaEndtime")));
        }
        m.setDiaValid("1".equals(params.get("diaValid")) || "有效".equals(params.get("diaValid")));
        m.setDiaHosLevel((String) params.get("diaHosLevel"));
        m.setDiaApprovalmark("1".equals(params.get("diaApprovalmark")) || "是".equals(params.get("diaApprovalmark")));
        return medicalInstitutionRepository.save(m);
    }

    @PutMapping("/api/medical-institutions/{id}")
    public MedicalInstitution update(@PathVariable("id") String diaId, @RequestBody Map<String, Object> params) throws ParseException {
        MedicalInstitution m = medicalInstitutionRepository.findById(diaId).orElse(null);
        if (m == null) return null;
        m.setDiaName((String) params.get("diaName"));
        m.setDiaExpType((String) params.get("diaExpType"));
        m.setDiaExpLevel((String) params.get("diaExpLevel"));
        Object maxPrizeObj = params.get("diaMaxPrize");
        if (maxPrizeObj != null && !maxPrizeObj.toString().isEmpty()) {
            m.setDiaMaxPrize(new BigDecimal(maxPrizeObj.toString()));
        } else {
            m.setDiaMaxPrize(null);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (params.get("diaStarttime") != null && !params.get("diaStarttime").toString().isEmpty()) {
            m.setDiaStarttime(sdf.parse((String) params.get("diaStarttime")));
        } else {
            m.setDiaStarttime(null);
        }
        if (params.get("diaEndtime") != null && !params.get("diaEndtime").toString().isEmpty()) {
            m.setDiaEndtime(sdf.parse((String) params.get("diaEndtime")));
        } else {
            m.setDiaEndtime(null);
        }
        m.setDiaValid("1".equals(params.get("diaValid")) || "有效".equals(params.get("diaValid")));
        m.setDiaHosLevel((String) params.get("diaHosLevel"));
        m.setDiaApprovalmark("1".equals(params.get("diaApprovalmark")) || "是".equals(params.get("diaApprovalmark")));
        return medicalInstitutionRepository.save(m);
    }

    @DeleteMapping("/api/medical-institutions/{id}")
    public void delete(@PathVariable("id") String diaId) {
        medicalInstitutionRepository.deleteById(diaId);
    }
} 