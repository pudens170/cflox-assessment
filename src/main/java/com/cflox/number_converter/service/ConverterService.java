package com.cflox.number_converter.service;

import com.cflox.number_converter.model.AuditTrail;
import com.cflox.number_converter.pojo.ApplicationResponse;

public interface ConverterService {

	public ApplicationResponse saveRequest(AuditTrail auditTrail);

}
