package com.cflox.number_converter.converter;

import org.springframework.stereotype.Component;

import com.cflox.number_converter.enumeration.ConversionType;

@Component
public class NumberFactory {

	public static Convertible getConverter(String converter) {

		if (converter.equalsIgnoreCase(ConversionType.NUMBER.value)) {
			return new NumberConverter();
		}

		else if (converter.equalsIgnoreCase(ConversionType.BINARY.value)) {
			return new BinaryToDecimalConverter();
		}

		throw new UnsupportedOperationException("Unsupported Converter: " + converter);

	}

}
