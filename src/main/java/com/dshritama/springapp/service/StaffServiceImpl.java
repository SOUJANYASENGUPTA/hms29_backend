package com.dshritama.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dshritama.springapp.model.Staff;
import com.dshritama.springapp.repository.StaffRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff existingStaff = staffRepository.findById(id).orElseThrow();
        existingStaff.setName(updatedStaff.getName());
        existingStaff.setAge(updatedStaff.getAge());
        existingStaff.setGender(updatedStaff.getGender());
        existingStaff.setAddress(updatedStaff.getAddress());
        existingStaff.setPhone(updatedStaff.getPhone());
        existingStaff.setEmail(updatedStaff.getEmail());
        existingStaff.setJobTitle(updatedStaff.getJobTitle());
        existingStaff.setSalary(updatedStaff.getSalary());
        existingStaff.setBenefits(updatedStaff.getBenefits());
        // Set other attributes here

        return staffRepository.save(existingStaff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

	@Override
	public Staff getDoctorById(Long id) {
		Staff doctor= staffRepository.findByJobTitle("Doctor");
		if(doctor!=null) {
			if(doctor.getId()==id) {
				return doctor;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

   

    
}

