package com.sudhir.SrpingWithControllerJPA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandller {

	@ExceptionHandler(value=LastNameNotFoudException.class)
	public ResponseEntity<Object> appException(LastNameNotFoudException ex){
		return new ResponseEntity<>("LastName not found, this field can not be empty",HttpStatus.NOT_FOUND);
	}
}
