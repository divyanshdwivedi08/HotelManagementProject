package com.hotel.management.demo.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.demo.Entity.Customer;
public interface CustomerRepo extends JpaRepository<Customer, Long> {
Optional<Customer> findByName(String name);
List<Customer> findByAge(Long age);
List<Customer> findByState(String state);
}
