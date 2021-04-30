package com.cflox.number_converter.enumeration;

public enum ConversionType {
	BINARY("Binary Conversion"), DECIMAL("Decimal Conversion ");

	public String value;

	private ConversionType(String value) {
		this.value = value;
	}
}
