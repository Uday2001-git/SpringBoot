package com.springboot.aop;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.exception.UsernameAsmailNotFoundException;

@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(value = UsernameAsmailNotFoundException.class)
	public ResponseEntity<Error> usernameAsmailNotFoundException(UsernameAsmailNotFoundException ex) {
		Error error = new Error();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		error.setMessage(ex.getMessage());
		error.setDateOfError(date.toString());
		error.setTimeOfError(time.toString());
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);

	}
}
