package com.cflox.number_converter.converter;

import org.springframework.stereotype.Component;

import com.cflox.number_converter.enumeration.ConversionType;

@Component
public class NumberFactory {

	
	public Convertible getConverter(String converter) {

		if (converter == null) {
			throw new UnsupportedOperationException("Unsupported Converter: "+converter);
		}
		if (converter.equalsIgnoreCase(ConversionType.DECIMAL.value)) {
			return new NumberConverter();
		}

		if (converter.equalsIgnoreCase(ConversionType.BINARY.value)) {
			return new BinaryToDecimalConverter();
		}
		 throw new UnsupportedOperationException("Unsupported Converter: "+converter);

	}

}
