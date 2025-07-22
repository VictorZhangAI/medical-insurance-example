package main.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_medical_institution")
public class MedicalInstitution {
    @Id
    @Column(name = "dia_id")
    private String diaId;

    @Column(name = "dia_name")
    private String diaName;

    @Column(name = "dia_exp_type")
    private String diaExpType;

    @Column(name = "dia_exp_level")
    private String diaExpLevel;

    @Column(name = "dia_max_prize")
    private BigDecimal diaMaxPrize;

    @Column(name = "dia_starttime")
    @Temporal(TemporalType.DATE)
    private Date diaStarttime;

    @Column(name = "dia_endtime")
    @Temporal(TemporalType.DATE)
    private Date diaEndtime;

    @Column(name = "dia_valid")
    private Boolean diaValid;

    @Column(name = "dia_hos_level")
    private String diaHosLevel;

    @Column(name = "dia_approvalmark")
    private Boolean diaApprovalmark;

    // getter 和 setter
    public String getDiaId() { return diaId; }
    public void setDiaId(String diaId) { this.diaId = diaId; }
    public String getDiaName() { return diaName; }
    public void setDiaName(String diaName) { this.diaName = diaName; }
    public String getDiaExpType() { return diaExpType; }
    public void setDiaExpType(String diaExpType) { this.diaExpType = diaExpType; }
    public String getDiaExpLevel() { return diaExpLevel; }
    public void setDiaExpLevel(String diaExpLevel) { this.diaExpLevel = diaExpLevel; }
    public BigDecimal getDiaMaxPrize() { return diaMaxPrize; }
    public void setDiaMaxPrize(BigDecimal diaMaxPrize) { this.diaMaxPrize = diaMaxPrize; }
    public Date getDiaStarttime() { return diaStarttime; }
    public void setDiaStarttime(Date diaStarttime) { this.diaStarttime = diaStarttime; }
    public Date getDiaEndtime() { return diaEndtime; }
    public void setDiaEndtime(Date diaEndtime) { this.diaEndtime = diaEndtime; }
    public Boolean getDiaValid() { return diaValid; }
    public void setDiaValid(Boolean diaValid) { this.diaValid = diaValid; }
    public String getDiaHosLevel() { return diaHosLevel; }
    public void setDiaHosLevel(String diaHosLevel) { this.diaHosLevel = diaHosLevel; }
    public Boolean getDiaApprovalmark() { return diaApprovalmark; }
    public void setDiaApprovalmark(Boolean diaApprovalmark) { this.diaApprovalmark = diaApprovalmark; }
} 