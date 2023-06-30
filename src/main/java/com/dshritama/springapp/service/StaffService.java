package com.dshritama.springapp.service;

import java.util.List;

import com.dshritama.springapp.model.Staff;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff createStaff(Staff staff);
    Staff updateStaff(Staff staff);
    void deleteStaff(Long id);
    Staff getStaffById(Long id);
    Staff getDoctorById(Long id);
}
