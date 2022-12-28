package com.inditex.prices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inditex.prices.DTO.ErrorMessageDTO;


@RestControllerAdvice
public class ApiExceptionHandlerController {
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity <ErrorMessageDTO> runtimeExceptionHandler(RuntimeException ex){
		ErrorMessageDTO errorMessage = ErrorMessageDTO.builder().code("P-500").message(ex.getMessage()).build();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity <ErrorMessageDTO> requestExceptionHandler(RequestException ex){
		ErrorMessageDTO errorMessage = ErrorMessageDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity <ErrorMessageDTO> businessExceptionHandler(BusinessException ex){
		ErrorMessageDTO errorMessage = ErrorMessageDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
		return new ResponseEntity<>(errorMessage, ex.getStatus());
	}
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler({
//		BadRequestException.class,
//		org.springframework.dao.DuplicateKeyException.class,
//		org.springframework.web.HttpRequestMethodNotSupportedException.class,
//		org.springframework.web.bind.MethodArgumentNotValidException.class,
//		org.springframework.web.bind.MissingRequestHeaderException.class,
//		org.springframework.web.bind.MissingServletRequestParameterException.class,
//		org.springframework.web.bind.method.annotation.MethodArgumentTypeMismatchException.class,
//		org.springframework.http.converter.HttpMessageNotReadableException.class
//	})

}


