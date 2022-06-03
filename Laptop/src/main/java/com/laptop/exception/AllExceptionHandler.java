package com.laptop.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {

	

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
	

	
    @ExceptionHandler(LaptopNotFoundException.class)
    public Map<String, String> handleBusinessException(LaptopNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
	
    

    @ExceptionHandler(NumberFormatException.class)
    public Map<String, String> handleBusinessExceptiont(NumberFormatException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", "Invalid Input");
        return errorMap;
    }
}
