package com.example.cruso1.resources.exceptions.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.cruso1.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExecptionHandler {
	//este metodo é padrao tem que ter esta acinatura para que usa @ControllerAdvice
	@ExceptionHandler
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
