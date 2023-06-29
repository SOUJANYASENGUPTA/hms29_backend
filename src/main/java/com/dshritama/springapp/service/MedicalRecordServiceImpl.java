package com.dshritama.springapp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dshritama.springapp.model.MedicalRecord;
import com.dshritama.springapp.model.Patient;
import com.dshritama.springapp.model.Staff;
import com.dshritama.springapp.repository.MedicalRecordRepository;
import com.dshritama.springapp.repository.PatientRepository;
import com.dshritama.springapp.repository.StaffRepository;
import jakarta.persistence.EntityNotFoundException;
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Override
	public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
    @Override
    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medical Record not found with ID: " + id));
    }

    @Override
    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        Patient patient = patientRepository.findById(medicalRecord.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        Staff doctor = staffRepository.findByJobTitle("Doctor");
        if (doctor == null) {
            throw new IllegalStateException("Doctor not found");
        }
        MedicalRecord newMedicalRecord = new MedicalRecord();
        newMedicalRecord.setPatientId(patient.getId());
        newMedicalRecord.setDoctorId(doctor.getId());
        newMedicalRecord.setDate(medicalRecord.getDate());
        newMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
        newMedicalRecord.setPrescription(medicalRecord.getPrescription());
        newMedicalRecord.setNotes(medicalRecord.getNotes());
        medicalRecordRepository.save(newMedicalRecord);
        return new MedicalRecord(newMedicalRecord.getId(),newMedicalRecord.getDate(),newMedicalRecord.getDiagnosis(),newMedicalRecord.getPrescription(),newMedicalRecord.getNotes(),newMedicalRecord.getPatientId(),newMedicalRecord.getDoctorId());
    }

    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord record=medicalRecordRepository.findById(medicalRecord.getId()).orElseThrow(() -> new EntityNotFoundException("Medical Record not found with ID: " + medicalRecord.getId()));
        if(record!=null) {
        	record.setId(medicalRecord.getId());
        	record.setDate(medicalRecord.getDate());
        	record.setDiagnosis(medicalRecord.getDiagnosis());
        	record.setNotes(medicalRecord.getNotes());
        	record.setPrescription(medicalRecord.getPrescription());
        	record.setDoctorId(medicalRecord.getDoctorId());
        	record.setPatientId(medicalRecord.getPatientId());
        	medicalRecordRepository.save(record);
        	return record;
        }
        else {
        	return null;
        }
    }

    @Override
    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }

    @Override
    public List<MedicalRecord> getRecordsByPatientId(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }
}
