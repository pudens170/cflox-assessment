package com.cflox.number_converter.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class BinaryToDecimalConverterTest {

	private BinaryToDecimalConverter numberConverter;

	
	@BeforeEach
	public void setUp() {
		numberConverter = new BinaryToDecimalConverter();
	}

	@Test
	@DisplayName("Bnary to Digit Conversion successful test")
	public void convertSucessTest() {
		String input = "100100";
		String result = numberConverter.convert(input);
		assertThat(result).isEqualTo("36");
	}
	
	@Test
	@DisplayName("Null input test")
	public void numberOutOfRangeTest() {
		String input = null;
		assertThrows(NullPointerException.class, () -> numberConverter.convert(input));

	}

}
