package com.cflox.number_converter.pojo;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unused")
public class ApplicationResponse {

	private int status;
	private String message;
	private LocalDateTime timestamp;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	

}
