package com.hotel.management.demo.Controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
@GetMapping("/test/{n}")
public String test(@RequestParam String name,@PathVariable int n) {
	System.out.println("Hello");
	return "Hey"+" "+name+ String.valueOf(n);
}
}
