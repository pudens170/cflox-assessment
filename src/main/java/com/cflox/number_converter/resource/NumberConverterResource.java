package com.cflox.number_converter.resource;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cflox.number_converter.converter.Convertible;
import com.cflox.number_converter.converter.NumberValidator;
import com.cflox.number_converter.enumeration.ConversionType;
import com.cflox.number_converter.model.AuditTrail;
import com.cflox.number_converter.pojo.ConverterResponsePojo;
import com.cflox.number_converter.service.ConverterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class NumberConverterResource {

	@Autowired
	private Convertible converter;

	@Autowired
	private ConverterService converterService;

	@Autowired
	private ConverterResponsePojo converterResponsePojo;

	@GetMapping
	@ApiOperation(value = "convert to roman numerals", notes = "convert either binary or decimal to roman numerals", response = ConverterResponsePojo.class)
	public ConverterResponsePojo convertNumber(
			@ApiParam(value = "number that you want to convert to roman equivalent", required = true) @RequestParam("number") String numberToConvert) {
		String result;
		Optional<String> resultOpt = Optional.ofNullable(converter.convert(numberToConvert));
		if (resultOpt.isPresent()) {
			result = resultOpt.get();
			ConversionType conversionType = NumberValidator.getConversionType(numberToConvert);
			AuditTrail auditTrail = new AuditTrail(conversionType, LocalDateTime.now(), numberToConvert, result);
			converterService.saveRequest(auditTrail);
			converterResponsePojo.setOuput(result);

		}

		return converterResponsePojo;
	}
}
