package com.example.ecom.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice    // It defines how your server responds to various exceptions.
public class GlobalExceptionHandler {
	//if id not Found in Service Controller then orElseThrow Method Throw here Here i give Response
		@ExceptionHandler(ResourceNotFoundException.class)
		public String HandelResourseNotFoundException(ResourceNotFoundException ex){			
			return ex.getMessage() ;
		}
}
