package com.cflox.number_converter.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cflox.number_converter.enumeration.ConversionType;
import com.cflox.number_converter.exception.NumberOutOfRangeException;


@SpringBootTest
public class NumberConverterTest {

	@Autowired
	private NumberConverter numberConverter;

	@Test
	@DisplayName("Conversion successfull test")
	public void convertSucessTest() {
		String input = "1996";
		String result = numberConverter.convert(input);
		assertThat(result).isEqualTo("MCMXCVI");
	}

	@Test
	@DisplayName("Conversion failure test")
	public void convertFailureTest() {
		String input = "1996";
		String result = numberConverter.convert(input);
		assertThat(result).isNotEqualTo("MCMXCVII");

	}

	@Test
	@DisplayName("Number out of range test")
	public void numberOutOfRangeTest() {
		String input = "4000";
		assertThrows(NumberOutOfRangeException.class, () -> numberConverter.convert(input));

	}
	@Test
	public  void getConversionType() {
		String input = "100100";
		String result = numberConverter.convert(input);	
		assertThat(result).isEqualTo("XXXVI");
		
	}
}
