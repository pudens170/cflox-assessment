package com.cflox.number_converter.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cflox.number_converter.exception.NumberOutOfRangeException;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class NumberConverterTest {

	private NumberConverter numberConverter;

	
	@BeforeEach
	public void setUp() {
		numberConverter = new NumberConverter();
	}

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
}
