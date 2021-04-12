package br.com.gestaohoras.api.controller.mocks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaohoras.api.dto.LancamentoPostDTO;
import br.com.gestaohoras.api.dto.LancamentoPostDTO.FuncionarioDTO;
import br.com.gestaohoras.api.dto.LancamentoPutDTO;
import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.enums.PeriodoEnum;
import br.com.gestaohoras.api.enums.TipoEnum;

public class LancamentoControllerMocks {
	
	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public LancamentoPostDTO test_adicionarLancamento() {
		
		return lancamentoPostDTOMock1();
	}
	
	public List<LancamentoResponseDTO> test_findAll(){
		List<LancamentoResponseDTO> mock = new ArrayList<>();
		
		mock.add(lancamentoResponseDTOMock1());
		mock.add(lancamentoResponseDTOMock2());
		mock.add(lancamentoResponseDTOMock3());
		
		return mock;
	}
	
	
	public LancamentoResponseDTO test_adicionarLancamentoResponseDTO() {
		LancamentoResponseDTO mock = new LancamentoResponseDTO();
		mock.setId(1L);
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		return mock;
	}
	
	public static FuncionarioDTO funcionarioMock() {
		FuncionarioDTO mock = new FuncionarioDTO();
		mock.setId(1L);
		return mock;
	}
	
	public LancamentoPutDTO test_atualizarLancamento() {
		LancamentoPutDTO mock = new LancamentoPutDTO();
		
		mock.setHorario(LocalTime.of(8, 00));
		mock.setIdFuncionario(1L);
		
		return mock;
	}
	
	public static LancamentoPostDTO lancamentoPostDTOMock1(){
		
		LancamentoPostDTO mock = new LancamentoPostDTO();
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setFuncionario(funcionarioMock());
		mock.setHorario(LocalTime.of(8, 00));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		return mock;
	}
	
	public static LancamentoResponseDTO lancamentoResponseDTOMock1() {
		LancamentoResponseDTO mock = new LancamentoResponseDTO();
		
		mock.setId(1L);
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		
		return mock;
	}
	
	public static LancamentoResponseDTO lancamentoResponseDTOMock2() {
		LancamentoResponseDTO mock = new LancamentoResponseDTO();
		
		mock.setId(2L);
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.SAIDA);
		
		return mock;
	}
	
	public static LancamentoResponseDTO lancamentoResponseDTOMock3() {
		LancamentoResponseDTO mock = new LancamentoResponseDTO();
		
		mock.setId(1L);
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setPeriodo(PeriodoEnum.TARDE);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		
		return mock;
	}
	
}
