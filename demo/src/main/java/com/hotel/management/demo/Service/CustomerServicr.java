package com.hotel.management.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.management.demo.Entity.Customer;
import com.hotel.management.demo.Entity.CustomerDTO;
import com.hotel.management.demo.Exception.ResourceNotFoundException;
import com.hotel.management.demo.Repository.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServicr {

    private final CustomerRepo customerRepo;

    public Customer save(CustomerDTO customerDTO) {

        Customer customer =
                Customer.builder()
                .name(customerDTO.getName())
                .age(customerDTO.getAge())
                .state(customerDTO.getState())
                .city(customerDTO.getCity())
                .build();

        return customerRepo.save(customer);
    }


    public List<Customer> showAllMyMan() {

        return customerRepo.findAll();
    }


    public Customer findById(Long id){

        return customerRepo
                .findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException(
                                "Customer not found with id : "
                                        + id
                        ));
    }


    public Customer findByName(String name){

        return customerRepo
                .findByName(name)
                .orElseThrow(()->
                        new ResourceNotFoundException(
                                "Customer not found : "
                                        + name
                        ));
    }


    public void deleteById(Long id){

        Customer customer =
                customerRepo
                        .findById(id)
                        .orElseThrow(()->
                                new ResourceNotFoundException(
                                        "Customer not found with id : "
                                                + id
                                ));

        customerRepo.delete(customer);

    }


    public Customer updateById(
            Long id,
            CustomerDTO customerDTO) {

        Customer cust =
                customerRepo
                .findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException(
                                "Customer not found : "
                                        + id
                        ));

        cust.setName(customerDTO.getName());
        cust.setAge(customerDTO.getAge());
        cust.setState(customerDTO.getState());
        cust.setCity(customerDTO.getCity());

        return customerRepo.save(cust);
    }
}