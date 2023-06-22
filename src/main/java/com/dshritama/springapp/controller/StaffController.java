package com.dshritama.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dshritama.springapp.model.Staff;
import com.dshritama.springapp.repository.StaffRepository;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    // GET all staff members
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // GET a specific staff member
    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable Long id) {
        return staffRepository.findById(id);
    }

    // CREATE a new staff member
    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    // UPDATE an existing staff member
    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff updatedStaff) {
        Staff existingStaff = staffRepository.findById(id).orElseThrow();
        existingStaff.setName(updatedStaff.getName());
        existingStaff.setAge(updatedStaff.getAge());
        // Set other attributes here

        return staffRepository.save(existingStaff);
    }

    // DELETE a staff member
    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffRepository.deleteById(id);
    }
}
