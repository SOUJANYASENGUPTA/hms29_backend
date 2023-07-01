package com.dshritama.springapp.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonPropertyOrder({"id", "medication_name", "dosage", "refill_date", "prescription_number", "patient_id"})
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("patient_id")
    private Long patientId;

    @JsonProperty("medication_name")
    private String medicationName;

    @JsonProperty("dosage")
    private String dosage;

    @JsonProperty("refill_date")
    private Date refillDate;

    @JsonProperty("prescription_number")
    private String prescriptionNumber;


    public Pharmacy() {
    }

    public Pharmacy(Long id, Long patientId, String medicationName, String dosage, Date refillDate,
            String prescriptionNumber) {
        this.id = id;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.refillDate = refillDate;
        this.prescriptionNumber = prescriptionNumber;
        
    }

    @Override
    public String toString() {
        return "Pharmacy [id=" + id  + ", medicationName=" + medicationName + ", dosage="
                + dosage + ", refillDate=" + refillDate + ", prescriptionNumber=" + prescriptionNumber + ", patientId=" + patientId + "]";
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


}
