package main.controller;

import main.model.Medicine;
import main.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/api/medicines")
    public List<Medicine> getAllMedicines(
        @RequestParam(value = "medicineName", required = false) String medicineName,
        @RequestParam(value = "medicineID", required = false) String medicineID
    ) {
        if ((medicineName == null || medicineName.isEmpty()) && (medicineID == null || medicineID.isEmpty())) {
            return medicineRepository.findAll();
        } else if (medicineName != null && !medicineName.isEmpty() && (medicineID == null || medicineID.isEmpty())) {
            return medicineRepository.findByMedNameContaining(medicineName);
        } else if ((medicineName == null || medicineName.isEmpty()) && medicineID != null && !medicineID.isEmpty()) {
            return medicineRepository.findByMedIdContaining(medicineID);
        } else {
            return medicineRepository.findByMedNameContainingAndMedIdContaining(medicineName, medicineID);
        }
    }

    @GetMapping("/api/medicines/{id}")
    public Medicine getMedicineById(@PathVariable("id") String medId) {
        return medicineRepository.findById(medId).orElse(null);
    }

    @PostMapping("/api/medicines")
    public Medicine addMedicine(@RequestBody Map<String, Object> params) throws ParseException {
        Medicine medicine = new Medicine();
        medicine.setMedId((String) params.get("medicineID"));
        medicine.setMedName((String) params.get("medicineName"));
        medicine.setMedMeasurement((String) params.get("medicineUnit"));
        medicine.setMedSize((String) params.get("medicineSpec"));
        medicine.setMedTradename((String) params.get("productName"));
        medicine.setMedExpType((String) params.get("chargeType"));
        medicine.setMedExpLevel((String) params.get("chargeLevel"));
        Object maxPriceObj = params.get("maxPrice");
        if (maxPriceObj != null && !maxPriceObj.toString().isEmpty()) {
            medicine.setMedMaxPrice(new BigDecimal(maxPriceObj.toString()));
        }
        // 日期格式转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        if (params.get("startDate") != null && !params.get("startDate").toString().isEmpty()) {
            medicine.setMedStarttime(sdf.parse((String) params.get("startDate")));
        }
        if (params.get("endDate") != null && !params.get("endDate").toString().isEmpty()) {
            medicine.setMedEndtime(sdf.parse((String) params.get("endDate")));
        }
        // 有效标志
        medicine.setMedValid("有效".equals(params.get("validFlag")));
        // 特检特质标志
        medicine.setMedSpecialmark("是".equals(params.get("specialFlag")));
        // 需要审批标志（前端暂未提供，默认false）
        medicine.setMedApprovalMark(false);
        // 医院等级（前端暂未提供，设为null）
        medicine.setMedHosLevel(null);
        return medicineRepository.save(medicine);
    }

    @PutMapping("/api/medicines/{id}")
    public Medicine updateMedicine(@PathVariable("id") String medId, @RequestBody Map<String, Object> params) throws ParseException {
        Medicine medicine = medicineRepository.findById(medId).orElse(null);
        if (medicine == null) return null;
        medicine.setMedName((String) params.get("medicineName"));
        medicine.setMedMeasurement((String) params.get("medicineUnit"));
        medicine.setMedSize((String) params.get("medicineSpec"));
        medicine.setMedTradename((String) params.get("productName"));
        medicine.setMedExpType((String) params.get("chargeType"));
        medicine.setMedExpLevel((String) params.get("chargeLevel"));
        Object maxPriceObj = params.get("maxPrice");
        if (maxPriceObj != null && !maxPriceObj.toString().isEmpty()) {
            medicine.setMedMaxPrice(new java.math.BigDecimal(maxPriceObj.toString()));
        } else {
            medicine.setMedMaxPrice(null);
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        if (params.get("startDate") != null && !params.get("startDate").toString().isEmpty()) {
            medicine.setMedStarttime(sdf.parse((String) params.get("startDate")));
        } else {
            medicine.setMedStarttime(null);
        }
        if (params.get("endDate") != null && !params.get("endDate").toString().isEmpty()) {
            medicine.setMedEndtime(sdf.parse((String) params.get("endDate")));
        } else {
            medicine.setMedEndtime(null);
        }
        medicine.setMedValid("有效".equals(params.get("validFlag")));
        medicine.setMedSpecialmark("是".equals(params.get("specialFlag")));
        return medicineRepository.save(medicine);
    }

    @DeleteMapping("/api/medicines/{id}")
    public void deleteMedicine(@PathVariable("id") String medId) {
        medicineRepository.deleteById(medId);
    }
} 