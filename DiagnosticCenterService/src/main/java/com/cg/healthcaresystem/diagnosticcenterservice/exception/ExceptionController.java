package com.cg.healthcaresystem.diagnosticcenterservice.exception;

import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(DiagnosticCenterNotFoundException.class)
	public String handleexception(DiagnosticCenterNotFoundException exp) {
		return exp.getMessage();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException exp) {
	    Map<String, String> errors = new HashMap<>();
	     
	    exp.getConstraintViolations().forEach(constv -> {
	        errors.put("message", constv.getMessage());
	        errors.put("path", (constv.getPropertyPath()).toString());
	    }); 
	 
	    return errors;
	}

}