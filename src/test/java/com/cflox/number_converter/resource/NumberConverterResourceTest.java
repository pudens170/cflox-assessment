package com.cflox.number_converter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@AutoConfigureMockMvc
public class NumberConverterResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	
}