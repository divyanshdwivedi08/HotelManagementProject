package com.hotel.management.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
@GetMapping("/heyBro")
public String returnSomethingMan(@RequestParam String name) {
	return "Hey Bro"+ " "+name;
}
}
