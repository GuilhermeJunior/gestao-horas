package br.com.gestaohoras.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gestaohoras.api.enums.PeriodoEnum;
import br.com.gestaohoras.api.enums.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoResponseDTO {
	
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate data;
	private PeriodoEnum periodo;
	private TipoEnum tipoLancamento;
	
}
