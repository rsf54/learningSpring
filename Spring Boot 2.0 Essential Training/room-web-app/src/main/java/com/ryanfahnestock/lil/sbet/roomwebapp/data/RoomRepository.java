package com.ryanfahnestock.lil.sbet.roomwebapp.data;

import com.ryanfahnestock.lil.sbet.roomwebapp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
