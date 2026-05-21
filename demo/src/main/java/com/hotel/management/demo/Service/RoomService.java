package com.hotel.management.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.management.demo.Entity.Room;
import com.hotel.management.demo.Entity.RoomDTO;
import com.hotel.management.demo.Exception.ResourceNotFoundException;
import com.hotel.management.demo.Repository.RoomRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepo roomRepository;

    public Room saveRoom(RoomDTO dto) {

        Room room =
                Room.builder()
                .roomNumber(dto.getRoomNumber())
                .roomType(dto.getRoomType())
                .pricePerNight(dto.getPricePerNight())
                .roomStatus(dto.getRoomStatus())
                .build();

        return roomRepository.save(room);
    }


    public List<Room> getAllRooms() {

        return roomRepository.findAll();
    }


    public Room getByIdRooms(Long roomId) {

        return roomRepository
                .findById(roomId)
                .orElseThrow(()->
                        new ResourceNotFoundException(
                                "Room not found with id : "
                                        + roomId
                        ));
    }
}