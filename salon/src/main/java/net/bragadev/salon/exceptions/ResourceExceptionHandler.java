package net.bragadev.salon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MyException.class)
	public ResponseEntity<String> ObjectNotFoundException(MyException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
	}
	
}
