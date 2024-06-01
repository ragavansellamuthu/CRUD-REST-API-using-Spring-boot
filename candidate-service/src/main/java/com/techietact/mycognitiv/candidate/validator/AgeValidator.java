package com.techietact.mycognitiv.candidate.validator;

import com.techietact.mycognitiv.candidate.annotation.Age;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer>{

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		return age>=18;
	}

}
