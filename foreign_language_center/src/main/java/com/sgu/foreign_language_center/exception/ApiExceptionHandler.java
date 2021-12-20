package com.sgu.foreign_language_center.exception;

public class ApiExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ApiExceptionHandler(String message) {
		super(message);
	};

}
