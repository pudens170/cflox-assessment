package com.cflox.number_converter.enumeration;

public enum Error {
	INVALID_FORMAT("Oops! An error has just occured,this could be because you supplied a wrong  input"),
	AUDIT_RECORD_NOT_SAVED("Sorry we couldn't save your record,no audit was supplied"),
	EMPTY_INPUT("Oops! You didn't supply any input"),
	UNSUPPORTED_OPERATION("Oops! An error occured,this could be because you supplied an unsupported conversion type"),
	OUT_OF_RANGE("Oops! The input allowed is either binary or decimal within the range of 1 to 3999");

	public String value;

	private Error(String value) {
		this.value = value;
	}

}
