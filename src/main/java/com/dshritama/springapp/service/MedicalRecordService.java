package com.dshritama.springapp.service;

import java.util.List;

import com.dshritama.springapp.model.MedicalRecord;

public interface MedicalRecordService {
	public List<MedicalRecord> getAllMedicalRecords();
	public MedicalRecord getMedicalRecordById(Long id);
	public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord);
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);
	public void deleteMedicalRecord(Long id);
	public List<MedicalRecord> getRecordsByPatientId(Long patientId);
}
