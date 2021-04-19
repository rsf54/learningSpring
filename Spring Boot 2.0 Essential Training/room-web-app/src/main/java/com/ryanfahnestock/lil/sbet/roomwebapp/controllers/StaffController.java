package com.ryanfahnestock.lil.sbet.roomwebapp.controllers;


import com.ryanfahnestock.lil.sbet.roomwebapp.models.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private static final List<Staff> staff = new ArrayList<>();
    static{
        for(int i=0;i<5;i++){
            staff.add(new Staff(i, "S"+i,"First","Last","Temp"));
        }
    }

    @GetMapping
    public String getAllStaff(Model model){
        model.addAttribute("staff",staff);
        return "staff";
    }
}
