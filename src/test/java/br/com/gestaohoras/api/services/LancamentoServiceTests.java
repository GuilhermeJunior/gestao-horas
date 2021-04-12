package br.com.gestaohoras.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.exceptions.FuncionarioNotFound;
import br.com.gestaohoras.api.exceptions.LancamentoNotFound;
import br.com.gestaohoras.api.interfaces.LancamentoService;
import br.com.gestaohoras.api.mapper.LancamentoMapper;
import br.com.gestaohoras.api.model.Funcionario;
import br.com.gestaohoras.api.model.Lancamento;
import br.com.gestaohoras.api.repository.FuncionarioRepository;
import br.com.gestaohoras.api.repository.LancamentoRepository;
import br.com.gestaohoras.api.service.LancamentoServiceImpl;
import br.com.gestaohoras.api.services.mocks.LancamentoServiceMocks;

@ExtendWith(MockitoExtension.class)
public class LancamentoServiceTests {
	
	private LancamentoService service;
	
	@Mock
	private LancamentoRepository repository;
	
	@Mock 
	private FuncionarioRepository funcionarioRepository;
	
	@Spy
	private LancamentoMapper mapper = Mappers.getMapper(LancamentoMapper.class);
	
	@BeforeEach
	void setup() {
		service = new LancamentoServiceImpl(repository, mapper, funcionarioRepository);
	}
	
	@Test
	@DisplayName("Deve retornar um dto de Lançamentos")
	void test_adicionaLancamento() {
		//Given
		Mockito.when(repository.save(ArgumentMatchers.any(Lancamento.class)))
		.thenReturn(LancamentoServiceMocks.test_salvarLancamento());
		//When
		Optional<LancamentoResponseDTO> actual = Optional.of(service.adicionaLancamento(LancamentoServiceMocks.test_adicionarLancamento()));
		//Then
		assertTrue(actual.isPresent());
		
	}
	
	@Test
	@DisplayName("Deve retornar uma lista de dto de Lançamentos por funcionário")
	void test_findaAll() {
		//Given
		Mockito.when(funcionarioRepository.findById(ArgumentMatchers.anyLong()))
		.thenReturn(Optional.of(LancamentoServiceMocks.funcionarioMock()));
		//And
		Mockito.when(repository.findByFuncionario(ArgumentMatchers.any()))
		.thenReturn(LancamentoServiceMocks.test_findAll());
		//And
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		//When
		List<LancamentoResponseDTO> actual = service.findAll(funcionario.getId());
		//Then
		assertFalse(actual.isEmpty());
		assertEquals(3L, actual.size());
		
	}
	
	@Test
	@DisplayName("Deve retonar uma erro de Funcionário not Found")
	void test_findAll_exception() {
		//Given
		Mockito.when(funcionarioRepository.findById(ArgumentMatchers.anyLong()))
		.thenReturn(Optional.empty());
		//And
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		//When
		Exception exception = assertThrows(FuncionarioNotFound.class, () -> service.findAll(funcionario.getId()));
		//Then
		assertEquals("Funcionáro com o id " + funcionario.getId() + " não encontrado", exception.getMessage());
	}
	
	@Test
	@DisplayName("Atualizar um horário de lançamento")
	void test_atualizaLancamento() {
		//Given 
		Mockito.when(repository.findById(ArgumentMatchers.anyLong()))
		.thenReturn(Optional.of(LancamentoServiceMocks.lancamentoMock1()));
		//And
		//Given
		Mockito.when(repository.save(ArgumentMatchers.any(Lancamento.class)))
		.thenReturn(LancamentoServiceMocks.test_salvarLancamento());
		//And
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		//When
	    Optional<LancamentoResponseDTO> actual = Optional.of(service.atualizaLancamento(LancamentoServiceMocks.lancamentoPutDTOMock(), funcionario.getId()));
	    //Then
	    assertTrue(actual.isPresent());
	}
	
	@Test
	@DisplayName("Deve retornar uma exception ao tentar atualizar id não encontrado")
	void test_atualizalancamento_exception() {
		//When
		Mockito.when(repository.findById(ArgumentMatchers.anyLong()))
		.thenReturn(Optional.empty());
		//And
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		
		Exception exception = assertThrows(LancamentoNotFound.class, () -> service.atualizaLancamento(LancamentoServiceMocks.lancamentoPutDTOMock(), funcionario.getId()));
		assertEquals("Lancamento com o id + " + funcionario.getId() + " não encontrado", exception.getMessage());
	}
	
}
