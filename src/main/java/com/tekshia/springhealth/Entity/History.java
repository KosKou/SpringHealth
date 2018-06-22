package com.tekshia.springhealth.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                //Historial
    @Column
    private String hospital;        //Hospital
    @Column
    @Temporal(TemporalType.DATE)
    private Date attentionDate;     //Get in
    @Column
    private String reason;          //Razon
    @Column
    private String description;     //Descripcion
    @Column
    private String doctorName;      //Nombre de Doctor
    @ManyToOne
    private Patient patient;
    @Column(name = "drugs")
    private String drugs;
    //    Array From Drugs
//    private ArrayList<Drug> drugArrayList;


    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(Date attentionDate) {
        this.attentionDate = attentionDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
