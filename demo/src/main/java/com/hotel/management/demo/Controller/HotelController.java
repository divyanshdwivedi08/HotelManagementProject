package com.hotel.management.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.demo.Entity.Customer;
import com.hotel.management.demo.Entity.CustomerDTO;
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
public ResponseEntity<Customer> test(@RequestBody CustomerDTO cust) {
	 Customer save = sr.save(cust);
	return ResponseEntity.status(HttpStatus.CREATED).body(save);

}
@GetMapping("/showAllData")
public List<Customer> nCustomer(){
	return sr.showAllMyMan();
}
@GetMapping("findById/{id}")
public Optional<Customer> findBydId(@PathVariable Long id){
	return sr.findById(id);
}
@GetMapping("findByName/{name}")
public ResponseEntity<Customer> findByName(@PathVariable String name) {
	 Customer byName = sr.findByName(name);
	return ResponseEntity.status(HttpStatus.CREATED).body(byName);
}
@DeleteMapping("/{id}")
public String delete(@PathVariable Long id) {
	sr.deleteById(id);
	return String.valueOf(id)+" "+"deleted!";
}

@PostMapping("/updateData/{id}")
public Customer updateData(@PathVariable Long id,@RequestBody CustomerDTO custDTO) {
	return sr.updateById(id, custDTO);
}
}
