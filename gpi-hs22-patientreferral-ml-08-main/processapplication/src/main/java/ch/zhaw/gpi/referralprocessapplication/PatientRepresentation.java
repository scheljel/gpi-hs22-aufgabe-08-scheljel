package ch.zhaw.gpi.referralprocessapplication;

import java.util.Date;

public class PatientRepresentation {
    private Long insuranceNumber;
    private String last_name;
    private String first_name;
    private Date birth_date;
    private Long plz;
    private String insurance_type;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Long getPlz() {
        return plz;
    }

    public void setPlz(Long plz) {
        this.plz = plz;
    }

    public String getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(String insurance_type) {
        this.insurance_type = insurance_type;
    }

    public Long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

}
