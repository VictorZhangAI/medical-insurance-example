package main.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_service_facilities")
public class ServiceFacilities {
    @Id
    @Column(name = "ser_id")
    private String serId;

    @Column(name = "ser_name")
    private String serName;

    @Column(name = "ser_exp_type")
    private String serExpType;

    @Column(name = "ser_starttime")
    @Temporal(TemporalType.DATE)
    private Date serStarttime;

    @Column(name = "ser_endtime")
    @Temporal(TemporalType.DATE)
    private Date serEndtime;

    @Column(name = "ser_valid")
    private Boolean serValid;

    // getter 和 setter
    public String getSerId() { return serId; }
    public void setSerId(String serId) { this.serId = serId; }
    public String getSerName() { return serName; }
    public void setSerName(String serName) { this.serName = serName; }
    public String getSerExpType() { return serExpType; }
    public void setSerExpType(String serExpType) { this.serExpType = serExpType; }
    public Date getSerStarttime() { return serStarttime; }
    public void setSerStarttime(Date serStarttime) { this.serStarttime = serStarttime; }
    public Date getSerEndtime() { return serEndtime; }
    public void setSerEndtime(Date serEndtime) { this.serEndtime = serEndtime; }
    public Boolean getSerValid() { return serValid; }
    public void setSerValid(Boolean serValid) { this.serValid = serValid; }
} 