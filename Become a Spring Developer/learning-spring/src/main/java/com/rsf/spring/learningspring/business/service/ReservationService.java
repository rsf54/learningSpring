package com.rsf.spring.learningspring.business.service;

import com.rsf.spring.learningspring.business.domain.RoomReservation;
import com.rsf.spring.learningspring.data.repository.GuestRepository;
import com.rsf.spring.learningspring.data.repository.ReservationRepository;
import com.rsf.spring.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date){
        return null;
    }
}
