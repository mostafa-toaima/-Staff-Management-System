package com.mt.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mt.crud.Staff;
import com.mt.crud.service.StaffService;

import jakarta.validation.Valid;


@Controller
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("addNewStaff", staffService.getStaffById(id));
        return "addNewStaff";
    }
    
    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addNewStaff") Staff staff, BindingResult result) {
        if (result.hasErrors()) return "addNewStaff";
        staffService.submitStaff(staff);
        return "redirect:/getAllStaff";
    }

    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", staffService.getAllStaff());
        return "getAllStaff";
    }
}
