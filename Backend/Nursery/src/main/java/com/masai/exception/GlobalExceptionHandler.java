package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorDetails> exception(Exception e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(PlantException.class)
public ResponseEntity<ErrorDetails> PlantException(PlantException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(NoHandlerFoundException.class)
public ResponseEntity<ErrorDetails> NoHandlerFoundException(NoHandlerFoundException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorDetails> MethodArgumentNotValidException(MethodArgumentNotValidException e,WebRequest req){
	log.error("bad request");
	return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(CustomerException.class)
public ResponseEntity<ErrorDetails> handleCustomerExceptions(CustomerException ce,WebRequest req){
	
	ErrorDetails myErrorDetails = new ErrorDetails();
	
	
	
	return new ResponseEntity<ErrorDetails>(new ErrorDetails(ce.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
}

}
