package main.controller;

import main.model.DiagnosisProject;
import main.repository.DiagnosisProjectRepository;
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
public class DiagnosisProjectController {
    @Autowired
    private DiagnosisProjectRepository diagnosisProjectRepository;

    @GetMapping("/api/diagnosis-projects")
    public List<DiagnosisProject> getAll(
        @RequestParam(value = "diaName", required = false) String diaName,
        @RequestParam(value = "diaID", required = false) String diaID
    ) {
        if ((diaName == null || diaName.isEmpty()) && (diaID == null || diaID.isEmpty())) {
            return diagnosisProjectRepository.findAll();
        } else if (diaName != null && !diaName.isEmpty() && (diaID == null || diaID.isEmpty())) {
            return diagnosisProjectRepository.findByDiaNameContaining(diaName);
        } else if ((diaName == null || diaName.isEmpty()) && diaID != null && !diaID.isEmpty()) {
            return diagnosisProjectRepository.findByDiaIdContaining(diaID);
        } else {
            return diagnosisProjectRepository.findByDiaNameContainingAndDiaIdContaining(diaName, diaID);
        }
    }

    @GetMapping("/api/diagnosis-projects/{id}")
    public DiagnosisProject getById(@PathVariable("id") String diaId) {
        return diagnosisProjectRepository.findById(diaId).orElse(null);
    }

    @PostMapping("/api/diagnosis-projects")
    public DiagnosisProject add(@RequestBody Map<String, Object> params) throws ParseException {
        DiagnosisProject d = new DiagnosisProject();
        d.setDiaId((String) params.get("diaID"));
        d.setDiaName((String) params.get("diaName"));
        d.setDiaExpType((String) params.get("diaExpType"));
        d.setDiaExpLevel((String) params.get("diaExpLevel"));
        Object maxPrizeObj = params.get("diaMaxPrize");
        if (maxPrizeObj != null && !maxPrizeObj.toString().isEmpty()) {
            d.setDiaMaxPrize(new BigDecimal(maxPrizeObj.toString()));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (params.get("diaStarttime") != null && !params.get("diaStarttime").toString().isEmpty()) {
            d.setDiaStarttime(sdf.parse((String) params.get("diaStarttime")));
        }
        if (params.get("diaEndtime") != null && !params.get("diaEndtime").toString().isEmpty()) {
            d.setDiaEndtime(sdf.parse((String) params.get("diaEndtime")));
        }
        d.setDiaValid("1".equals(params.get("diaValid")) || "有效".equals(params.get("diaValid")));
        d.setDiaHosLevel((String) params.get("diaHosLevel"));
        d.setDiaApprovalmark("1".equals(params.get("diaApprovalmark")) || "是".equals(params.get("diaApprovalmark")));
        return diagnosisProjectRepository.save(d);
    }

    @PutMapping("/api/diagnosis-projects/{id}")
    public DiagnosisProject update(@PathVariable("id") String diaId, @RequestBody Map<String, Object> params) throws ParseException {
        DiagnosisProject d = diagnosisProjectRepository.findById(diaId).orElse(null);
        if (d == null) return null;
        d.setDiaName((String) params.get("diaName"));
        d.setDiaExpType((String) params.get("diaExpType"));
        d.setDiaExpLevel((String) params.get("diaExpLevel"));
        Object maxPrizeObj = params.get("diaMaxPrize");
        if (maxPrizeObj != null && !maxPrizeObj.toString().isEmpty()) {
            d.setDiaMaxPrize(new BigDecimal(maxPrizeObj.toString()));
        } else {
            d.setDiaMaxPrize(null);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (params.get("diaStarttime") != null && !params.get("diaStarttime").toString().isEmpty()) {
            d.setDiaStarttime(sdf.parse((String) params.get("diaStarttime")));
        } else {
            d.setDiaStarttime(null);
        }
        if (params.get("diaEndtime") != null && !params.get("diaEndtime").toString().isEmpty()) {
            d.setDiaEndtime(sdf.parse((String) params.get("diaEndtime")));
        } else {
            d.setDiaEndtime(null);
        }
        d.setDiaValid("1".equals(params.get("diaValid")) || "有效".equals(params.get("diaValid")));
        d.setDiaHosLevel((String) params.get("diaHosLevel"));
        d.setDiaApprovalmark("1".equals(params.get("diaApprovalmark")) || "是".equals(params.get("diaApprovalmark")));
        return diagnosisProjectRepository.save(d);
    }

    @DeleteMapping("/api/diagnosis-projects/{id}")
    public void delete(@PathVariable("id") String diaId) {
        diagnosisProjectRepository.deleteById(diaId);
    }
} 