package com.cflox.number_converter.enumeration;

public enum ConversionType {
	BINARY("Binary Converter"), DECIMAL("Decimal Converter "),NUMBER("Number Converter");

	public String value;

	private ConversionType(String value) {
		this.value = value;
	}
}
