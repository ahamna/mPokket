package co.app.contactlist.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.app.contactlist.exceptions.ContactNotFound;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ContactNotFound.class)
	public ResponseEntity<String> contactNotFound(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
