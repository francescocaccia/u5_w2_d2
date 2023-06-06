package controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class PrenotazioniControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void shouldReturnRulesInItalian() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/info/italiano")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnRulesInEnglish() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/info/inglese")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnBadRequest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/info/giapponese")).andExpect(status().isBadRequest());
	}
}
