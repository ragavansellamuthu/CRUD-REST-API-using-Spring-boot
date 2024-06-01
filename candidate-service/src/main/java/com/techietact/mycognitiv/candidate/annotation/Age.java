package com.techietact.mycognitiv.candidate.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.techietact.mycognitiv.candidate.validator.AgeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	String message() default "Candidate is under-aged";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
