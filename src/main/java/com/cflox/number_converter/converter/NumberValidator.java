package com.cflox.number_converter.converter;

import org.springframework.stereotype.Component;

import com.cflox.number_converter.enumeration.ConversionType;

@Component
public class NumberValidator {

	public static boolean isBinary(String number) {
		if (number.length() == 1) {
			return false;
		}
		if (number.startsWith("1") && number.substring(1, number.length()).matches("[0]+")) {
			return false;
		}
		if (number.matches("[01]+") && !number.startsWith("0")) {
			return true;
		}

		return false;
	}

	public static boolean isNumberWithinRange(int number) {
		if (number <= 0 || number > 3999) {
			return false;
		}
		return true;
	}
	
	public static ConversionType getConversionType(String number) {
		if(isBinary(number)) {
			return ConversionType.BINARY;
		}
		return ConversionType.DECIMAL;
	}
}
