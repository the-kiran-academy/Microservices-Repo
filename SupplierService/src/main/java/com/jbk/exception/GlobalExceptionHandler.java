package com.jbk.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException( MethodArgumentNotValidException ex) {
		Map<String, String> errorMap=new HashMap<>();
		
		List<FieldError> fieldErrors = ex.getFieldErrors();
		
		for (FieldError fieldError : fieldErrors) {
			
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			
			errorMap.put(fieldName, message);
			
		}
		
		return errorMap;
		
	}
	

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public CustomExceptionResponse resourceAlreadyExistsException(ResourceAlreadyExistsException ex,
			HttpServletRequest request) {

		String msg = ex.getMessage();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());

		String path = request.getRequestURI();

		CustomExceptionResponse response = new CustomExceptionResponse(path, timeStamp, msg);

		return response;
	}

	@ExceptionHandler(ResourceNotExistsException.class)
	public CustomExceptionResponse resourceNotExistsException(ResourceNotExistsException ex, HttpServletRequest request) {
		String msg = ex.getMessage();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());

		String path = request.getRequestURI();

		CustomExceptionResponse response = new CustomExceptionResponse(path, timeStamp, msg);
		return response;
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	public CustomExceptionResponse somethingWentWrongException(SomethingWentWrongException ex, HttpServletRequest request) {
		String msg = ex.getMessage();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());

		String path = request.getRequestURI();

		CustomExceptionResponse response = new CustomExceptionResponse(path, timeStamp, msg);
		return response;
	}
	

}
