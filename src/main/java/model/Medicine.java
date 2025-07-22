package main.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_medicine")
public class Medicine {
    @Id
    @Column(name = "med_id")
    private String medId;

    @Column(name = "med_name")
    private String medName;

    @Column(name = "med_exp_type")
    private String medExpType;

    @Column(name = "med_exp_level")
    private String medExpLevel;

    @Column(name = "med_measurement")
    private String medMeasurement;

    @Column(name = "med_max_price")
    private BigDecimal medMaxPrice;

    @Column(name = "med_approvalmark")
    private Boolean medApprovalMark;

    @Column(name = "med_hos_level")
    private String medHosLevel;

    @Column(name = "med_size")
    private String medSize;

    @Column(name = "med_tradename")
    private String medTradename;

    @Column(name = "med_starttime")
    @Temporal(TemporalType.DATE)
    private Date medStarttime;

    @Column(name = "med_endtime")
    @Temporal(TemporalType.DATE)
    private Date medEndtime;

    @Column(name = "med_valid")
    private Boolean medValid;

    @Column(name = "med_specialmark")
    private Boolean medSpecialmark;

    // getter 和 setter
    public String getMedId() { return medId; }
    public void setMedId(String medId) { this.medId = medId; }
    public String getMedName() { return medName; }
    public void setMedName(String medName) { this.medName = medName; }
    public String getMedExpType() { return medExpType; }
    public void setMedExpType(String medExpType) { this.medExpType = medExpType; }
    public String getMedExpLevel() { return medExpLevel; }
    public void setMedExpLevel(String medExpLevel) { this.medExpLevel = medExpLevel; }
    public String getMedMeasurement() { return medMeasurement; }
    public void setMedMeasurement(String medMeasurement) { this.medMeasurement = medMeasurement; }
    public BigDecimal getMedMaxPrice() { return medMaxPrice; }
    public void setMedMaxPrice(BigDecimal medMaxPrice) { this.medMaxPrice = medMaxPrice; }
    public Boolean getMedApprovalMark() { return medApprovalMark; }
    public void setMedApprovalMark(Boolean medApprovalMark) { this.medApprovalMark = medApprovalMark; }
    public String getMedHosLevel() { return medHosLevel; }
    public void setMedHosLevel(String medHosLevel) { this.medHosLevel = medHosLevel; }
    public String getMedSize() { return medSize; }
    public void setMedSize(String medSize) { this.medSize = medSize; }
    public String getMedTradename() { return medTradename; }
    public void setMedTradename(String medTradename) { this.medTradename = medTradename; }
    public Date getMedStarttime() { return medStarttime; }
    public void setMedStarttime(Date medStarttime) { this.medStarttime = medStarttime; }
    public Date getMedEndtime() { return medEndtime; }
    public void setMedEndtime(Date medEndtime) { this.medEndtime = medEndtime; }
    public Boolean getMedValid() { return medValid; }
    public void setMedValid(Boolean medValid) { this.medValid = medValid; }
    public Boolean getMedSpecialmark() { return medSpecialmark; }
    public void setMedSpecialmark(Boolean medSpecialmark) { this.medSpecialmark = medSpecialmark; }
} 