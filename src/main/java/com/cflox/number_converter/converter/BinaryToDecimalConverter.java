package com.cflox.number_converter.converter;

import com.cflox.number_converter.enumeration.Error;

public class BinaryToDecimalConverter implements Convertible {
	BinaryToDecimalConverter() {
	}

	@Override
	public String convert(String input) {
		if (input == null) {
			throw new NullPointerException(Error.EMPTY_INPUT.value);
		}

		int binaryNumber = Integer.parseInt(input);
		int decimal = 0;
		int base = 1;
		while (binaryNumber > 0) {
			int lastDigit = binaryNumber % 10;
			binaryNumber = binaryNumber / 10;
			decimal += lastDigit * base;
			base = base * 2;
		}
		return String.valueOf(decimal);

	}
}
