package com.cflox.number_converter.pojo;

import org.springframework.stereotype.Component;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel("Details about the equivalent roman numeral ")
public class ConverterResponsePojo {
	@ApiModelProperty("converted roman numeral  output")
	private String ouput;

	public ConverterResponsePojo() {
	}

	public ConverterResponsePojo(String ouput) {
		this.ouput = ouput;

	}

	public String getOuput() {
		return ouput;
	}

	public void setOuput(String ouput) {
		this.ouput = ouput;
	}

}
