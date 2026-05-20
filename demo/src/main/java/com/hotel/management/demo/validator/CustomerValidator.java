package com.hotel.management.demo.validator;

import com.hotel.management.demo.Entity.Customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<Validtor,Customer> {

	@Override
	public boolean isValid(Customer value, ConstraintValidatorContext context) {
		if(value == null)
			return false;
		if(value.getAge() <=18 || value.getAge()>100)
			return false;
		if(value.getState().equalsIgnoreCase("Delhi"))
			return true;
		
		return value!=null;
	}

}
