package com.ryanfahnestock.lil.sbet.roomwebapp.controllers;

import com.ryanfahnestock.lil.sbet.roomwebapp.models.Room;
import com.ryanfahnestock.lil.sbet.roomwebapp.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestContoller {
    private final RoomService roomService;

    public RoomRestContoller(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
}
