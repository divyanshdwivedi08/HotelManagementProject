package com.hotel.management.demo.Repository;
import com.hotel.management.demo.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
