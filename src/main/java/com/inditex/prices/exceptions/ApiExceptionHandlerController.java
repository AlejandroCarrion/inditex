package com.inditex.prices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inditex.prices.DTO.ErrorMessageDTO;


/**
 * @author acarriog
 * Controlador ApiExceptionHandlerController encargado de gestionar las excepciones
 */
@RestControllerAdvice
public class ApiExceptionHandlerController {
	
	/**
	 * Métotodo @ExceptionHandler encargado de controlar las excepciones RuntimeException 
	 * @param ex (RuntimeException)
	 * @return ResponseEntity<ErrorMessageDTO>
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity <ErrorMessageDTO> runtimeExceptionHandler(RuntimeException ex){
		ErrorMessageDTO errorMessage = ErrorMessageDTO.builder().code("P-500").message(ex.getMessage()).build();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Métotodo @ExceptionHandler encargado de controlar las excepciones RequestException 
	 * @param ex (RequestException)
	 * @return ResponseEntity<ErrorMessageDTO>
	 */
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity <ErrorMessageDTO> requestExceptionHandler(RequestException ex){
		ErrorMessageDTO errorMessage = ErrorMessageDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Métotodo @ExceptionHandler encargado de controlar las excepciones BusinessException 
	 * @param ex (BusinessException)
	 * @return ResponseEntity<ErrorMessageDTO>
	 */
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity <ErrorMessageDTO> businessExceptionHandler(BusinessException ex){
		ErrorMessageDTO errorMessage = ErrorMessageDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
		return new ResponseEntity<>(errorMessage, ex.getStatus());
	}
	
}


