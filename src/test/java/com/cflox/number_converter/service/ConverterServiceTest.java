package com.cflox.number_converter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cflox.number_converter.enumeration.ConversionType;
import com.cflox.number_converter.enumeration.Success;
import com.cflox.number_converter.model.AuditTrail;
import com.cflox.number_converter.pojo.ApplicationResponse;
import com.cflox.number_converter.repository.AuditTrailRepository;

@SpringBootTest
public class ConverterServiceTest {
	@Mock
	private AuditTrailRepository auditrepository;
	@InjectMocks
	private ConverterServiceImpl converterService;

	@Test
	@DisplayName("SAVE AUDIT TRAIL SAVE SUCCESS")
	public void saveAuditTrailTest() {
		AuditTrail auditTrail = new AuditTrail(ConversionType.DECIMAL, LocalDateTime.now(), "40", "XL");
		when(auditrepository.save((any(AuditTrail.class)))).thenReturn(auditTrail);
		ApplicationResponse actualResponse = converterService.saveRequest(auditTrail);
		assertThat(actualResponse.getMessage()).isEqualTo(Success.RECORD_SAVED.value);
	}

	@Test
	@DisplayName("AUDIT TRAIL SAVE ERROR")
	public void failPersistenceAuditTrailTest() {
		AuditTrail auditTrail = null;
		assertThrows(NullPointerException.class, () -> converterService.saveRequest(auditTrail));
	}
}
