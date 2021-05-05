package com.cflox.number_converter.converter;

import org.springframework.stereotype.Component;

@Component
public class NumberFactory {

	public static Convertible getConverter(String converter) {

		if (converter.equalsIgnoreCase("Number Converter")) {
			return new NumberConverter();
		}

		else if (converter.equalsIgnoreCase("Binary Converter")) {
			return new BinaryToDecimalConverter();
		}
		
		
		throw new UnsupportedOperationException("Unsupported Converter: " + converter);

	}

}
