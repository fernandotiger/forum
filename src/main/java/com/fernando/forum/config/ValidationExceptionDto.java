package com.fernando.forum.config;

public class ValidationExceptionDto {

	public String fieldName;
	
	public String message;

	public ValidationExceptionDto(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}
	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}
	
	
}
