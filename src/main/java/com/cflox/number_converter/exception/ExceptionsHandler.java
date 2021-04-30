package com.cflox.number_converter.exception;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.cflox.number_converter.enumeration.Error;
import com.cflox.number_converter.pojo.ApplicationResponse;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	static Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);
	ApplicationResponse response = new ApplicationResponse();

	@ExceptionHandler
	public ResponseEntity<ApplicationResponse> handleException(NumberFormatException e) {
		response.setMessage(Error.INVALID_FORMAT.value);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ApplicationResponse> handleException(NumberOutOfRangeException e) {
		response.setMessage(Error.OUT_OF_RANGE.value);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
