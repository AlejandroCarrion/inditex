package com.inditex.prices.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
/**
 * @author acarriog
 * clase encargada de gestionar las excepciones BusinessException (excepciones de negocio)
 */
@Data
public class BusinessException extends RuntimeException{

	private String code;
	private HttpStatus status;
	
	public BusinessException(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status; 
	}
	
}
