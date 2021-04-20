package com.ryanfahnestock.lil.sbet.roomwebapp.service;

import com.ryanfahnestock.lil.sbet.roomwebapp.data.StaffRepository;
import com.ryanfahnestock.lil.sbet.roomwebapp.models.Staff;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping
    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }
}
