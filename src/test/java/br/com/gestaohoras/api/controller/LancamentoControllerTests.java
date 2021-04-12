package br.com.gestaohoras.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;

import br.com.gestaohoras.api.adapters.LocalDateAdapter;
import br.com.gestaohoras.api.adapters.LocalTimeAdapter;
import br.com.gestaohoras.api.controller.mocks.LancamentoControllerMocks;
import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.interfaces.LancamentoService;

@WebMvcTest(LancamentoController.class)
public class LancamentoControllerTests {
	
	private static final LancamentoControllerMocks MOCKS = new LancamentoControllerMocks();
	private static final Gson GSON = new Gson();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LancamentoService service;
	
	@Test
	@DisplayName("Deve Retornar o status 201")
	void test_adicionarLancamento_201() throws Exception {
		//Given
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/lancamentos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(GSON.newBuilder()
						.setPrettyPrinting()
						.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
						.registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
						.create().toJson(MOCKS.test_adicionarLancamento())
						)
				;
		//And
		LancamentoResponseDTO mock = MOCKS.test_adicionarLancamentoResponseDTO();
		Mockito.when(service.adicionaLancamento(Mockito.any()))
		.thenReturn(mock);
		//When
		mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
		//Then
		.andExpect(MockMvcResultMatchers.status().isCreated())
		;
	}
	
	@Test
	@DisplayName("Deve retornar status 200 na atualizacao de horário")
	void test_atualizarLancamento_200() throws Exception{
		//Given
		RequestBuilder request = MockMvcRequestBuilders
				.put("/api/lancamentos/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(GSON.newBuilder()
						.setPrettyPrinting()
						.registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
						.create().toJson(MOCKS.test_atualizarLancamento()))
						;
		//And
		LancamentoResponseDTO mock = MOCKS.test_adicionarLancamentoResponseDTO();
		Mockito.when(service.atualizaLancamento(Mockito.any(), Mockito.any()))
		.thenReturn(mock);
		//When
		mockMvc.perform(request).andDo(print())
		//Then
		.andExpect(status().isOk())
		;
						
	}
	
	@Test
	@DisplayName("Deve retornar status 200 ao acessar endpoint findAll")
	void test_findAll() throws Exception {
		//Given
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/lancamentos")
				.queryParam("idFuncionario", "1")
				;
		//And
		List<LancamentoResponseDTO> mock = MOCKS.test_findAll();
		//And
		Mockito.when(service.findAll(Mockito.any()))
		.thenReturn(mock);
		//When
		mockMvc.perform(request).andDo(print())
		//Then
		.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deve retornar status 400 obrigando informar idFuncionario")
	void test_findAll_400() throws Exception {
		//Given
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/lancamentos");
		//When
		mockMvc.perform(request).andDo(print())
		//Then
		.andExpect(status().isBadRequest())
		.andExpect(status().reason("Required Long parameter 'idFuncionario' is not present"))
		;
	}
	
}
