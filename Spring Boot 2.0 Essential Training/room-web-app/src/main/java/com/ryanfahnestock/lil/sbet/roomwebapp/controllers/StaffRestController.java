package com.ryanfahnestock.lil.sbet.roomwebapp.controllers;

import com.ryanfahnestock.lil.sbet.roomwebapp.models.Staff;
import com.ryanfahnestock.lil.sbet.roomwebapp.service.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {
    private final StaffService staffService;

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff(){ return staffService.getAllStaff();}
}
