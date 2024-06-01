package com.techietact.mycognitiv.candidate.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.techietact.mycognitiv.candidate.response.ErrorResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends Exception{

	private static final long serialVersionUID = -118487552102286087L;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exception(Exception e){
		
		log.debug(e);
		
		int statusCode = 0; 
		
		if( e instanceof IllegalArgumentException || e instanceof MethodArgumentTypeMismatchException || 
			e instanceof MethodArgumentNotValidException) {
			statusCode = 400 ;
//		}else if( e instanceof AuthenticationException ) { // After Security Implementation
//			statusCode = 401 ;
//		}else if (e instanceof AccessDeniedException) {
//            statusCode = 403 ;
        } else if (e instanceof EntityNotFoundException || e instanceof NoResourceFoundException) {
            statusCode = 404 ;
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            statusCode = 405 ;
        }else {
			statusCode = 500 ; 
		}
		
		ErrorResponse model = new ErrorResponse(statusCode,e.getMessage(),null);
		
		log.info(model);	
		
		return ResponseEntity.internalServerError().body(model);
	}
	

}
