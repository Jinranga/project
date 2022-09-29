package com.example.spring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomerException extends RuntimeException{
	
private static final long serialVersionUID=1L;
	
	public CustomerException(String message) {
		super(message);
	}
	public CustomerException(String message,Throwable throwable) {
		super(message,throwable);
	}

}
