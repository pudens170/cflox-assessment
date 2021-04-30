package com.cflox.number_converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cflox.number_converter.enumeration.Error;
import com.cflox.number_converter.enumeration.Success;
import com.cflox.number_converter.model.AuditTrail;
import com.cflox.number_converter.pojo.ApplicationResponse;
import com.cflox.number_converter.repository.AuditTrailRepository;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	private AuditTrailRepository auditTrailRepository;

	@Override
	public ApplicationResponse saveRequest(AuditTrail auditTrail) {
		ApplicationResponse response = new ApplicationResponse();
		if (auditTrail == null) {
			throw new NullPointerException(Error.AUDIT_RECORD_NOT_SAVED.value);

		}
		auditTrailRepository.save(auditTrail);
		response.setMessage(Success.RECORD_SAVED.value);

		return response;

	}
}
