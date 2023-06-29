package com.dshritama.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dshritama.springapp.model.MedicalRecord;
import com.dshritama.springapp.service.MedicalRecordService;

import java.util.List;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {
	@Autowired
    private  MedicalRecordService medicalRecordService;
	
    // GET /medical-records
    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    // GET /medical-records/{id}
    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecordById(@PathVariable Long id) {
        return medicalRecordService.getMedicalRecordById(id);
    }

    // POST /medical-records
    @PostMapping
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.createMedicalRecord(medicalRecord);
    }

    // PUT /medical-records
    @PutMapping
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.updateMedicalRecord(medicalRecord);
    }

    // DELETE /medical-records/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.ok("Deleted");
    }
}
