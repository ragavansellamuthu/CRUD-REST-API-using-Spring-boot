package com.techietact.mycognitiv.candidate.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.techietact.mycognitiv.candidate.response.ErrorResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomUtils {
	
	public static ResponseEntity<?> badRequest(BindingResult result) {
		Map<String, String> fieldErrors = new HashMap<>();
		for (FieldError error : result.getFieldErrors()) {
			fieldErrors.put(error.getField(), error.getDefaultMessage());
		}
		ErrorResponse model = new ErrorResponse(400, "Bad Request", fieldErrors);
		log.error(model);
		return ResponseEntity.badRequest().body(model);
	}

	public static Sort sort(String attributeName, String sortOrder) {
		if (StringUtils.hasText(attributeName) && StringUtils.hasText(sortOrder)) {
			if (sortOrder.equals("asc")) {
				return Sort.by(attributeName).ascending();
			} else {
				return Sort.by(attributeName).descending();
			}
		} else {
			return Sort.by("candidateId").ascending();
		}
	}

}
