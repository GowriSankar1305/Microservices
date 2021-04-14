package com.tectoro.moviecatalogservice.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tectoro.moviecatalogservice.model.ErrorResponse;

@ControllerAdvice
@SuppressWarnings("all")
public class CustomErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleException(Exception exception)	{
		logger.error("Exception occured :: {}",exception);
		ErrorResponse response = new ErrorResponse();
		response.setMessage("Exception occured");
		response.setTimeStamp(new Date().toLocaleString());
		response.setStatus("INTERNAL SERVER ERROR");
		response.setStatusCode(500);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException runtimeException) {
		logger.error("RuntimeException occured :: {}",runtimeException);
		ErrorResponse response = new ErrorResponse();
		response.setMessage("Runtime Exception occured");
		response.setTimeStamp(new Date().toLocaleString());
		response.setStatus("INTERNAL SERVER ERROR");
		response.setStatusCode(500);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
