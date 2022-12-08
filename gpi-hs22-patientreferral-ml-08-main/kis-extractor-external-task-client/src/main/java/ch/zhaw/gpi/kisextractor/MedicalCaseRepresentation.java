package ch.zhaw.gpi.kisextractor;

import java.util.Date;

public class MedicalCaseRepresentation {
    private Long referrer_id;
    private boolean is_emergency;
    private Date date_desired;
    private String responsible_department;
    private Date date_earliest;
    private Date date_latest;
    
    public Long getReferrer_id() {
        return referrer_id;
    }
    public void setReferrer_id(Long referrer_id) {
        this.referrer_id = referrer_id;
    }
    public boolean isIs_emergency() {
        return is_emergency;
    }
    public void setIs_emergency(boolean is_emergency) {
        this.is_emergency = is_emergency;
    }
    public Date getDate_desired() {
        return date_desired;
    }
    public void setDate_desired(Date date_desired) {
        this.date_desired = date_desired;
    }
    public String getResponsible_department() {
        return responsible_department;
    }
    public void setResponsible_department(String responsible_department) {
        this.responsible_department = responsible_department;
    }
    public Date getDate_earliest() {
        return date_earliest;
    }
    public void setDate_earliest(Date date_earliest) {
        this.date_earliest = date_earliest;
    }
    public Date getDate_latest() {
        return date_latest;
    }
    public void setDate_latest(Date date_latest) {
        this.date_latest = date_latest;
    }


    
}
