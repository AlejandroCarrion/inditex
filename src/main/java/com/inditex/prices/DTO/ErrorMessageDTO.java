package com.inditex.prices.DTO;

import lombok.Builder;
import lombok.Data;

/**
 * @author acarriog
 * DTO ErrorMessage encargado de mostrar el mensaje y código de error de las excepciones
 */
@Data
@Builder
public class ErrorMessageDTO {
	private String code;
	private String message;
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
