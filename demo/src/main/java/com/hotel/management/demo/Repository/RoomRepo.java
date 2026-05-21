package com.hotel.management.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.management.demo.Entity.Room;
public interface RoomRepo extends JpaRepository<Room, Long> {

}