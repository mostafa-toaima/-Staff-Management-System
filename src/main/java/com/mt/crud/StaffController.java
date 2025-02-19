package com.mt.crud;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class StaffController {

    List <Staff> allStaff = new ArrayList<>(); //this call same data add and not clear data
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
    
    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
        int index = generateIndex(id);
        model.addAttribute("addNewStaff", index == -1 ? new Staff() : allStaff.get(index));
        return "addNewStaff";
    }

    private int generateIndex(String id) {
        for (int i = 0; i < allStaff.size(); i++) {
            if (allStaff.get(i).getId().equals(id))
                return i;
        }
        return Constants.NO_MATCH;
    }

    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addNewStaff") Staff staff, BindingResult result) {
        if (result.hasErrors()) {
            
            return "addNewStaff";
        }
        int index = generateIndex(staff.getId());
        if (index == -1) {
            allStaff.add(staff);
        } else {
            allStaff.set(index, staff);
        }
        return "redirect:/getAllStaff";
    }
    
    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", allStaff);
        return "getAllStaff";
    }
}
