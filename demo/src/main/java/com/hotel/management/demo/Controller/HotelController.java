package com.hotel.management.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
@GetMapping
public String returnSomethingMan() {
	return "Hey Bro";
}
}
