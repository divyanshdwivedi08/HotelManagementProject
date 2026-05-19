package com.hotel.management.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.demo.Entity.Customer;
import com.hotel.management.demo.Entity.CustomerDTO;
import com.hotel.management.demo.Repository.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServicr {
@Autowired
private CustomerRepo customerRepo;
public Customer save(CustomerDTO customerDTO) {
	Customer customer = new Customer();
	//customer.setName(customerDTO.getName());
	Customer cust = Customer.builder()
			.name(customerDTO.getName())
			.age(customerDTO.getAge()).
			state(customerDTO.getState())
			.city(customerDTO.getCity())
			.build();
	Customer save = customerRepo.save(cust);
		return save;
}

public List<Customer> showAllMyMan() {
	List<Customer> all = customerRepo.findAll();
	return all;
}
public Optional<Customer> findById(Long id){
	Optional<Customer> byId = customerRepo.findById(id);
	return byId;
}

public Customer findByName(String name){
	Optional<Customer> byName = customerRepo.findByName(name);
	return byName.orElseThrow(()-> new RuntimeException("Not Found"));
}
public void deleteById(Long id) {
	customerRepo.deleteById(id);
}
public Customer updateById(Long id, CustomerDTO customerDTO) {
		Customer cust = customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
		cust.setAge(customerDTO.getAge());
		cust.setCity(customerDTO.getCity());
		cust.setName(customerDTO.getName());
		cust.setState(customerDTO.getState());
	Customer c=	customerRepo.save(cust);
		
		return Customer.builder()
				.id(c.getId())
				.name(cust.getName())
				.age(cust.getAge())
				.city(cust.getCity())
				.state(cust.getState()).build();
}
}

