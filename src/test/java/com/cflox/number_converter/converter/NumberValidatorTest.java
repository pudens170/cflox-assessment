package com.cflox.number_converter.converter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cflox.number_converter.enumeration.ConversionType;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class NumberValidatorTest {

	@Test
	@DisplayName("isBinary Success test")
	public void isBinaryConfirmationSuccessTest() {
		String input = "100100";
		boolean result = NumberValidator.isBinary(input);
		assertTrue(result);
	}

	@Test
	@DisplayName("isBinary Failure test")
	public void isBinaryFailureTest() {
		String input = "202";
		boolean result = NumberValidator.isBinary(input);
		assertFalse(result);
	}

	@Test
	@DisplayName("is binary when  input starts by one and followed by zeros Binary")
	public void inputStartingfromOneAndPorcedingWithAllZeroTest() {
		String input = "10000";
		boolean result = NumberValidator.isBinary(input);
		assertFalse(result);
	}

	@Test
	@DisplayName("is binary when input length more than one")
	public void inputLengthSucessTest() {
		String input = "1";
		boolean result = NumberValidator.isBinary(input);
		assertFalse(result);
	}

	@Test
	@DisplayName("Input within 1 to 3999")
	public void numberWithinRangeTest() {
		int input = 2000;
		boolean result = NumberValidator.isNumberWithinRange(input);
		assertTrue(result);
	}

	@Test
	@DisplayName("Binary conversion type")
	public void binaryConversionTypeTest() {
		String input = "100100";
		assertSame(ConversionType.BINARY, NumberValidator.getConversionType(input));
	}

	@Test
	@DisplayName("Decimal conversion type")
	public void decimalConversionTypeTest() {
		String input = "200";
		assertSame(ConversionType.DECIMAL, NumberValidator.getConversionType(input));
	}

	@Test
	@DisplayName("Input  below 1 and ouside 3999")
	public void NumberOutsideRangeTest() {
		int input = 4000;
		boolean result = NumberValidator.isNumberWithinRange(input);
		assertFalse(result);
	}
}
