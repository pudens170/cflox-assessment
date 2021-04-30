package com.cflox.number_converter.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cflox.number_converter.enumeration.ConversionType;
import com.cflox.number_converter.exception.NumberOutOfRangeException;

@Component
public class NumberConverter implements Convertible {

	NumberConverter() {
	}

	@Autowired
	private NumberFactory numberFactory;

	@Override
	public String convert(String input) {

		int number = Integer.parseInt(input.trim());
		boolean isBinary = NumberValidator.isBinary(input);

		if (isBinary) {
			ConversionType conversionType = ConversionType.BINARY;
			Convertible convertible = numberFactory.getConverter(conversionType.value);
			number = Integer.parseInt(convertible.convert(input));
		}
		if (!NumberValidator.isNumberWithinRange(number)) {
			throw new NumberOutOfRangeException();
		}

		String[] thousands = { "", "M", "MM", "MMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String result = thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10]
				+ units[number % 10];

		return result;
	}

}
