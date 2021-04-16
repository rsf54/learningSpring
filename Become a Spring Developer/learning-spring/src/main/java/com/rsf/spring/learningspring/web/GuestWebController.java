package com.rsf.spring.learningspring.web;


import com.rsf.spring.learningspring.business.domain.RoomReservation;
import com.rsf.spring.learningspring.business.service.ReservationService;
import com.rsf.spring.learningspring.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private final ReservationService reservationService;

    @Autowired
    public GuestWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model){
        Iterable<Guest> guests = this.reservationService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
