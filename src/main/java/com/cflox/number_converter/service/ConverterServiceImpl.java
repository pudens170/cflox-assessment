package com.cflox.number_converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cflox.number_converter.model.AuditTrail;
import com.cflox.number_converter.repository.AuditTrailRepository;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	private AuditTrailRepository auditTrailRepository;

	@Override
	public void saveRequest(AuditTrail auditTrail) {
		if (auditTrail != null) {
			 auditTrailRepository.save(auditTrail);
		
		}
	}
}
