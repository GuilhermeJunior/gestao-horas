package br.com.gestaohoras.api.interfaces;

import java.util.List;

import br.com.gestaohoras.api.dto.LancamentoPostDTO;
import br.com.gestaohoras.api.dto.LancamentoPutDTO;
import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.model.Lancamento;

public interface LancamentoService {
	
	public LancamentoResponseDTO adicionaLancamento(LancamentoPostDTO lancamento);
	
	public LancamentoResponseDTO atualizaLancamento(LancamentoPutDTO lancamentoAtualizado, Long id);
	
	public void validarLancamento(Lancamento lancamento);
	
	public List<LancamentoResponseDTO> findAll(Long idFuncionario);
}
