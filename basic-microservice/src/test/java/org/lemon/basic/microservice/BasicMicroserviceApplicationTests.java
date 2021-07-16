package org.lemon.basic.microservice;

import org.hamcrest.text.MatchesPattern;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class BasicMicroserviceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testBasicResponse() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/GBP");
		mockMvc.perform(request)
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andExpect(MockMvcResultMatchers.jsonPath("$.priceCode").value("GBP"))
		       .andExpect(MockMvcResultMatchers.jsonPath("$.timeStamp").isNotEmpty())
		       .andExpect(MockMvcResultMatchers.jsonPath("$.value").isNumber());
	}

}
