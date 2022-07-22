package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handler(RuntimeException e) {
		System.out.println("RuntimeException:" + e.getMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("RuntimeException:" + e.getMessage());
	}
}
