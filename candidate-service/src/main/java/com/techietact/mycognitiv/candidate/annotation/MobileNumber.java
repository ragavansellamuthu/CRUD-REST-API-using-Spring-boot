package com.techietact.mycognitiv.candidate.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.techietact.mycognitiv.candidate.validator.MobileNumberValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = MobileNumberValidator.class)
public @interface MobileNumber {

	String message() default "Mobile Number must be exactly 10 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
