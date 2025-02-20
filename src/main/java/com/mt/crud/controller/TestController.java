package com.mt.crud.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mt.crud.Staff;
import com.mt.crud.service.StaffService;

import jakarta.validation.Valid;


//@Controller
public class TestController {

    // List <Staff> allStaff = new ArrayList<>(); //this call same data add and not clear data
    // List<Staff> allStaff = Arrays.asList(
    //         // asList() method returns a fixed-size list backed by the specified array.
    //         //ArrayList is a resizable array, which can grow and shrink its size.
    //         new Staff("Mostafa", "Developer", 15000),
    //         new Staff("Ahmed", "Developer", 15000),
    //         new Staff("Mahmoud", "Developer", 15000),
    //         new Staff("Mohamed", "Developer", 15000),
    //         new Staff("Sara", "Developer", 15000)
    // );

    // @GetMapping("/staffdetials")
    // public String getStaffDetials(Model model) {
    //     Staff myStaff = new Staff("Mostafa", "Developer", 15000);

    //     model.addAttribute("Staff", myStaff);
    //     return "staffdetials";
    // }


    StaffService staffService = new StaffService();
    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
//        int index = staffService.getStaffIndex(id);
//        model.addAttribute("addNewStaff", index == Constants.NO_MATCH ? new Staff() : staffService.getStaffByIndex(index));
        model.addAttribute("addNewStaffTest", staffService.getStaffById(id));

        return "addNewStaffTest";
    }



    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addNewStaff") Staff staff, BindingResult result) {
        if (result.hasErrors()) {

            return "addNewStaffTest";
        }
        int index = staffService.getStaffIndex(staff.getId());
        if (index == -1) {
            staffService.addStaff(staff);
        } else {
            staffService.updateStaff(staff, index);
        }
        return "redirect:/getAllStaffTest";
    }

    @GetMapping("/getAllStaffTest")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaffTest", staffService.getAllStaff());
        return "getAllStaffTest";
    }
}
