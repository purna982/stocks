package com.purna.stocks.webservices.stock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.purna.stocks.webservices.test.RestfulWebServicesApplicationTests;

public class StockControllerTest extends RestfulWebServicesApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void retrieveStocks() throws Exception {
		mockMvc.perform(get("/getStocks")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));

	}

}
