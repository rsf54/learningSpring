package com.ryanfahnestock.lil.sbet.roomwebapp.service;

import com.ryanfahnestock.lil.sbet.roomwebapp.models.Staff;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {
    private static final List<Staff> staff = new ArrayList<>();
    static{
        for(int i=0;i<5;i++){
            staff.add(new Staff(i, "S"+i,"First","Last","Temp"));
        }
    }

    @GetMapping
    public List<Staff> getAllStaff(){
        return staff;
    }
}
