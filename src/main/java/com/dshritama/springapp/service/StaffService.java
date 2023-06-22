package com.dshritama.springapp.service;

import java.util.List;
import java.util.Optional;

import com.dshritama.springapp.model.Staff;

public interface StaffService {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(Long id);
    Staff createStaff(Staff staff);
    Staff updateStaff(Long id, Staff updatedStaff);
    void deleteStaff(Long id);
}

