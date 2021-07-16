package org.lemon.config.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ConfigServerApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testBasicResponse() throws Exception {
		//can only be used when Git repo is set up
		RequestBuilder request = MockMvcRequestBuilders.get("/config-server/development");
		mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("config-server"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.profiles[0]").value("development"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.propertySources[0].source").isNotEmpty());
	}

}
