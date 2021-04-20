package com.ryanfahnestock.lil.sbet.roomwebapp.data;

import com.ryanfahnestock.lil.sbet.roomwebapp.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, String> {
}
