package com.hotel.management.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hotel.management.demo.Entity.Customer;
import com.hotel.management.demo.Entity.CustomerDTO;
import com.hotel.management.demo.Entity.Room;
import com.hotel.management.demo.Entity.RoomDTO;
import com.hotel.management.demo.Service.CustomerServicr;
import com.hotel.management.demo.Service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HotelController {

    private final CustomerServicr sr;

    private final RoomService roomService;


    @GetMapping("/heyBro/{name}")
    public String returnSomethingMan(
            @PathVariable String name) {

        return "Hey Bro " + name;
    }


    @PostMapping("/saveData")
    public ResponseEntity<Customer>
    saveCustomer(
            @RequestBody CustomerDTO cust){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sr.save(cust));
    }


    @GetMapping("/showAllData")
    public ResponseEntity<List<Customer>>
    getAllCustomer(){

        return ResponseEntity.ok(
                sr.showAllMyMan()
        );
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer>
    findById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                sr.findById(id)
        );
    }


    @GetMapping("/findByName/{name}")
    public ResponseEntity<Customer>
    findByName(
            @PathVariable String name){

        return ResponseEntity.ok(
                sr.findByName(name)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    delete(@PathVariable Long id){

        sr.deleteById(id);

        return ResponseEntity.ok(
                "Deleted Successfully"
        );
    }


    @PostMapping("/updateData/{id}")
    public ResponseEntity<Customer>
    updateData(
            @PathVariable Long id,
            @RequestBody CustomerDTO dto){

        return ResponseEntity.ok(
                sr.updateById(id,dto)
        );
    }


    @PostMapping("/createRoom")
    public ResponseEntity<Room>
    saveRoom(
            @RequestBody RoomDTO dto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        roomService.saveRoom(dto)
                );
    }


    @GetMapping("/getRoom")
    public ResponseEntity<List<Room>>
    getRoom(){

        return ResponseEntity.ok(
                roomService.getAllRooms()
        );
    }


    @GetMapping("/getByIdRoom/{roomId}")
    public ResponseEntity<Room>
    getByIdRooms(
            @PathVariable Long roomId){

        return ResponseEntity.ok(
                roomService.getByIdRooms(roomId)
        );
    }

}