package com.hotel.management.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CustomerValidator.class) 
@Target({ ElementType.TYPE })                        
@Retention(RetentionPolicy.RUNTIME)
public @interface Validtor { 
    
    String message() default "The selected city does not match the selected state";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
