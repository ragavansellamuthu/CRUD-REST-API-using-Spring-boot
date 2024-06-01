package com.techietact.mycognitiv.candidate.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.techietact.mycognitiv.candidate.annotation.UniqueEmail;
import com.techietact.mycognitiv.candidate.service.CandidateService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	CandidateService candidateService ;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return StringUtils.hasText(email)?!candidateService.isDuplicateEmail(email):false;
	}

}
