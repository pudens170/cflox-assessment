package com.cflox.number_converter.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cflox.number_converter.enumeration.ConversionType;

@SpringBootTest
public class NumberValidatorTest {
	
	private NumberValidator numberValidator;
	
	@BeforeEach
	public void setUp() {
		numberValidator = new NumberValidator();
	}

	@Test
	@DisplayName("isBinary Success test")
	public void isBinaryConfirmationSuccessTest() {
		String input = "100100";
		boolean result = numberValidator.isBinary(input);
		assertTrue(result);
	}

	@Test
	@DisplayName("isBinary Failure test")
	public void isBinaryFailureTest() {
		String input = "202";
		boolean result = numberValidator.isBinary(input);
		assertFalse(result);
	}

	@Test
	@DisplayName("is binary when  input starts by one and followed by zeros Binary")
	public void inputStartingfromOneAndPorcedingWithAllZeroTest() {
		String input = "10000";
		boolean result = numberValidator.isBinary(input);
		assertFalse(result);
	}

	@Test
	@DisplayName("is binary when input length more than one")
	public void inputLengthSucessTest() {
		String input = "1";
		boolean result = numberValidator.isBinary(input);
		assertFalse(result);
	}

	@Test
	@DisplayName("Input within 1 to 3999")
	public void numberWithinRangeTest() {
		int input = 2000;
		boolean result = numberValidator.isNumberWithinRange(input);
		assertTrue(result);
	}

	@Test
	@DisplayName("Binary conversion type")
	public void binaryConversionTypeTest() {
		String input = "100100";
		assertEquals(ConversionType.BINARY, numberValidator.getConversionType(input));
	}

	@Test
	@DisplayName("Decimal conversion type")
	public void decimalConversionTypeTest() {
		String input = "200";
		assertEquals(ConversionType.DECIMAL, numberValidator.getConversionType(input));
	}

	@Test
	@DisplayName("Input  below 1 and ouside 3999")
	public void NumberOutsideRangeTest() {
		int input = 4000;
		boolean result = numberValidator.isNumberWithinRange(input);
		assertFalse(result);
	}
}
