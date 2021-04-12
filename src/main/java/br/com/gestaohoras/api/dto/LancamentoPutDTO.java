package br.com.gestaohoras.api.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoPutDTO {
	
	@NotNull
	@JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalTime horario;
	
	@NotNull
	private Long idFuncionario;

}
