package com.hotel.management.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.demo.Entity.Customer;
import com.hotel.management.demo.Service.CustomerServicr;

@RestController
public class HotelController {
	@Autowired
	private  CustomerServicr sr;
@GetMapping("/heyBro/{name}")
public String returnSomethingMan(@PathVariable String name) {
	return "Hey Bro"+ " "+name;
}
@PostMapping("/saveData")
public Customer test(@RequestBody Customer cust) {
	return sr.save(cust);

}
@GetMapping("/showAllData")
public List<Customer> nCustomer(){
	return sr.showAllMyMan();
}

}
