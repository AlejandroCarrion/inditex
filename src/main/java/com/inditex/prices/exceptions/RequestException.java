package com.inditex.prices.exceptions;

import lombok.Data;

/**
 * @author acarriog
 * clase encargada de gestionar las excepciones RequestException (excepciones de request)
 */
@Data
public class RequestException extends RuntimeException {
	private String code;
	
	public RequestException(String code, String message) {
		super(message);
		this.code = code;
	}

}
