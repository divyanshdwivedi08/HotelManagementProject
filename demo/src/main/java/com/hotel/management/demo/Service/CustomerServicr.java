package com.hotel.management.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.demo.Entity.Customer;
import com.hotel.management.demo.Repository.CustomerRepo;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerServicr {
@Autowired
private  CustomerRepo customerRepo ;

public Customer save(Customer cust) {
	return customerRepo.save(cust);
}
public List<Customer> showAllMyMan(){
	
	return customerRepo.findAll();
}

}
