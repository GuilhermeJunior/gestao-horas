package br.com.gestaohoras.api.services.mocks;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaohoras.api.dto.LancamentoPostDTO;
import br.com.gestaohoras.api.dto.LancamentoPutDTO;
import br.com.gestaohoras.api.dto.LancamentoPostDTO.FuncionarioDTO;
import br.com.gestaohoras.api.enums.PeriodoEnum;
import br.com.gestaohoras.api.enums.TipoEnum;
import br.com.gestaohoras.api.model.Funcionario;
import br.com.gestaohoras.api.model.Lancamento;

public class LancamentoServiceMocks {
	
	public static Lancamento test_salvarLancamento() {
		return lancamentoMock1();
	}

	
	public static Funcionario funcionarioMock() {
		Funcionario mock = new Funcionario();
		mock.setId(1L);
		mock.setMatricula("21217");
		mock.setNome("Joe Doe");
		return mock;
	}
	
	public static LancamentoPostDTO test_adicionarLancamento() {
		LancamentoPostDTO mock = new LancamentoPostDTO();
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setHorario(LocalTime.of(8, 00));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		mock.setFuncionario(funcionarioDTOMock());
		return mock;
	}
	
	public static FuncionarioDTO funcionarioDTOMock() {
		FuncionarioDTO mock = new FuncionarioDTO();
		mock.setId(1L);
		return mock;
	}
	
	public static List<Lancamento> test_findAll(){
		List<Lancamento> mock = new ArrayList<>();
		
		mock.add(lancamentoMock1());
		mock.add(lancamentoMock2());
		mock.add(lancamentoMock3());
		
		return mock;
		
	}
	
	public static Lancamento lancamentoMock1() {
		Lancamento mock = new Lancamento();
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setFuncionario(funcionarioMock());
		mock.setHorario(LocalTime.of(8, 00));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		mock.setDataRegistro(Instant.now());
		return mock;
	}
	
	public static Lancamento lancamentoMock2() {
		Lancamento mock = new Lancamento();
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setFuncionario(funcionarioMock());
		mock.setHorario(LocalTime.of(12, 00));
		mock.setPeriodo(PeriodoEnum.MANHA);
		mock.setTipoLancamento(TipoEnum.SAIDA);
		mock.setDataRegistro(Instant.now());
		return mock;
	}
	
	public static Lancamento lancamentoMock3() {
		Lancamento mock = new Lancamento();
		mock.setData(LocalDate.of(2021, 04, 10));
		mock.setFuncionario(funcionarioMock());
		mock.setHorario(LocalTime.of(13, 00));
		mock.setPeriodo(PeriodoEnum.TARDE);
		mock.setTipoLancamento(TipoEnum.ENTRADA);
		mock.setDataRegistro(Instant.now());
		return mock;
	}
	
	public static LancamentoPutDTO lancamentoPutDTOMock() {
		LancamentoPutDTO mock = new LancamentoPutDTO();
		mock.setHorario(LocalTime.of(8, 10));
		mock.setIdFuncionario(1L);
		return mock;
	}
}

