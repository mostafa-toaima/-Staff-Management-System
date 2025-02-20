package com.mt.crud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mt.crud.Staff;

@Repository
public class StaffRepository {
    private List<Staff> AllStaff = new ArrayList<>();

    public Staff getStaffByIndex(int index) {
        return AllStaff.get(index);
    }

    public void addStaff(Staff staff) {
        AllStaff.add(staff);
    }
    
    public void updateStaff(Staff staff, int index) {
        AllStaff.set(index, staff);
    }
    
    public List<Staff> getAllStaff() {
        return AllStaff;
    }
}
