package com.techietact.mycognitiv.candidate.model;

import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponseModel {

	private final int code ;
	
	private final String message ;
	
	private final Map<String,String> fieldErrors;
	
}
