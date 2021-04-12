package br.com.gestaohoras.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


import br.com.gestaohoras.api.enums.PeriodoEnum;
import br.com.gestaohoras.api.enums.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoPostDTO {
	
	@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate data;
	
	@NotNull
	private PeriodoEnum periodo;
	
	@NotNull
	private TipoEnum tipoLancamento;
	
	@NotNull
	@JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalTime horario;
	
	@NotNull
	private FuncionarioDTO funcionario;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class FuncionarioDTO {
		private Long id;
	}
}
