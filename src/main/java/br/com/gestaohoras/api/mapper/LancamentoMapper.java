package br.com.gestaohoras.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.gestaohoras.api.dto.LancamentoPostDTO;
import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.model.Lancamento;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {
	
	LancamentoResponseDTO modelToDto(Lancamento model);
	Lancamento postDtoTomodel(LancamentoPostDTO dto);
	
	List<LancamentoResponseDTO> listModelToDto(List<Lancamento> model);
}
