package com.cflox.number_converter.service;

import com.cflox.number_converter.model.AuditTrail;

public interface ConverterService {

	public void saveRequest(AuditTrail auditTrail);

}
