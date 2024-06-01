package com.techietact.mycognitiv.candidate.validator;

import com.techietact.mycognitiv.candidate.annotation.MobileNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<MobileNumber,Long>{

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return value >= 6000000000L && value<=9999999999L;
	}

}
