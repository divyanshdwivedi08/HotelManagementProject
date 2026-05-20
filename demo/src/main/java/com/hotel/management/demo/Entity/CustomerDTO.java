package com.hotel.management.demo.Entity;

import com.hotel.management.demo.validator.Validtor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validtor()
public class CustomerDTO {
private String name;
private long age;
private String city;
private String state;
}
