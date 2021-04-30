package com.cflox.number_converter.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.cflox.number_converter.enumeration.ConversionType;

@Entity
public class AuditTrail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	private ConversionType conversionType;
	private LocalDateTime timestamp;
	private String incomingParam;
	private String result;

	public AuditTrail() {
	}

	public AuditTrail(ConversionType conversionType, LocalDateTime timestamp, String incomingParam, String result) {
		this.conversionType = conversionType;
		this.timestamp = timestamp;
		this.incomingParam = incomingParam;
		this.result = result;
	}

	public ConversionType getConversionType() {
		return conversionType;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getIncomingParam() {
		return incomingParam;
	}

	public String getResult() {
		return result;
	}

}
