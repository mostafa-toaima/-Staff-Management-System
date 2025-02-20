package com.mt.crud.service;

import java.util.List;

import com.mt.crud.Constants;
import com.mt.crud.Staff;
import com.mt.crud.repository.StaffRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public Staff getStaffByIndex(int index) {
        return staffRepository.getStaffByIndex(index);
    }

    public Staff getStaffById(String id){
        int index = getStaffIndex(id);
        return index == Constants.NO_MATCH ? new Staff() : getStaffByIndex(index);
    };

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    public int getStaffIndex(String id) {
        for (int i = 0; i < getAllStaff().size(); i++) {
            if (getStaffByIndex(i).getId().equals(id))
                return i;
        }
        return Constants.NO_MATCH;
    }

    public void addStaff(Staff staff) {
        staffRepository.addStaff(staff);
    }

    public void updateStaff(Staff staff, int index) {
        staffRepository.updateStaff(staff, index);
    }

    public void submitStaff(Staff newStaff) {
        int index = getStaffIndex(newStaff.getId());
        if (index == Constants.NO_MATCH) {addStaff(newStaff);} 
        else {updateStaff(newStaff, index);}}
}
