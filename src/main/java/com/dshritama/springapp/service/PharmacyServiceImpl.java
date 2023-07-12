package com.dshritama.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dshritama.springapp.model.Patient;
import com.dshritama.springapp.model.Pharmacy;
import com.dshritama.springapp.repository.PatientRepository;
import com.dshritama.springapp.repository.PharmacyRepository;

@Service
public class PharmacyServiceImpl implements PharmacyService{
    @Autowired
    private final PharmacyRepository pharmacyRepository;
    private final PatientRepository patientRepository;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository, PatientRepository patientRepository) {
        this.pharmacyRepository = pharmacyRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy getPharmacyById(Long id) {
        return pharmacyRepository.findById(id).orElse(null);
    }

    @Override
    public Pharmacy createPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    public Pharmacy updatePharmacy(Pharmacy updatedPharmacy) {
        Pharmacy pharmacy = pharmacyRepository.findById(updatedPharmacy.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid pharmacy ID"));;
       
           
            pharmacy.setMedicationName(updatedPharmacy.getMedicationName());
            pharmacy.setDosage(updatedPharmacy.getDosage());
            pharmacy.setRefillDate(updatedPharmacy.getRefillDate());
            pharmacy.setPrescriptionNumber(updatedPharmacy.getPrescriptionNumber());
            pharmacy.setPatientId(updatedPharmacy.getPatientId());
            return pharmacyRepository.save(pharmacy);
        
    
    }

    @Override
    public void deletePharmacy(Long id) {
        pharmacyRepository.deleteById(id);
    }
 
}