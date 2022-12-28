package com.inditex.prices.DTO;

import lombok.Builder;
import lombok.Data;

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
