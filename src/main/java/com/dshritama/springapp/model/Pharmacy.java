package com.dshritama.springapp.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patientId")
    private Long patientId;

    @Column(name = "medicationName")
    private String medicationName;

    private String dosage;

    @Column(name = "refillDate")
    private Date refillDate;

    @Column(name = "prescriptionNumber")
    private String prescriptionNumber;

    public Pharmacy() {
    }

    public Pharmacy(Long id, Long patientId, String medicationName, String dosage, Date refillDate,
            String prescriptionNumber) {
        this.id = id;
        this.patientId = patientId;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.refillDate = refillDate;
        this.prescriptionNumber = prescriptionNumber;
    }

    @Override
    public String toString() {
        return "Pharmacy [id=" + id + ", patientId=" + patientId + ", medicationName=" + medicationName + ", dosage="
                + dosage + ", refillDate=" + refillDate + ", prescriptionNumber=" + prescriptionNumber + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getRefillDate() {
        return refillDate;
    }

    public void setRefillDate(Date refillDate) {
        this.refillDate = refillDate;
    }

    public String getPrescriptionNumber() {
        return prescriptionNumber;
    }

    public void setPrescriptionNumber(String prescriptionNumber) {
        this.prescriptionNumber = prescriptionNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", insertable = false, updatable = false)
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
