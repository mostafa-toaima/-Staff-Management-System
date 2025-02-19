package com.mt.crud;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Staff {
    @NotBlank(message = "Staff Name is mandatory")
    private String staffName;
    @NotBlank(message = "Staff Title is mandatory")
    private String staffTitle;
    private double staffSalary;
    private String id;

    public Staff(String staffName, String staffTitle, double staffSalary) {
        this.staffName = staffName;
        this.staffTitle = staffTitle;
        this.staffSalary = staffSalary;
    }

    public Staff() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public double getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(double staffSalary) {
        this.staffSalary = staffSalary;
    }
}

