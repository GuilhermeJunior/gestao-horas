package br.com.gestaohoras.api.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gestaohoras.api.dto.LancamentoPostDTO;
import br.com.gestaohoras.api.dto.LancamentoPutDTO;
import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.exceptions.FuncionarioNotFound;
import br.com.gestaohoras.api.exceptions.LancamentoNotFound;
import br.com.gestaohoras.api.interfaces.LancamentoService;
import br.com.gestaohoras.api.mapper.LancamentoMapper;
import br.com.gestaohoras.api.model.Funcionario;
import br.com.gestaohoras.api.model.Lancamento;
import br.com.gestaohoras.api.repository.FuncionarioRepository;
import br.com.gestaohoras.api.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService{
	
	
	private final LancamentoRepository repository;
	private final LancamentoMapper mapper;
	private final FuncionarioRepository funcionarioRepository;
	
	@Override
	public LancamentoResponseDTO adicionaLancamento(LancamentoPostDTO lancamento) {
		
		Lancamento novoLancamento = mapper.postDtoTomodel(lancamento);
		novoLancamento.setDataRegistro(Instant.now());
		repository.save(novoLancamento);
		
		return mapper.modelToDto(novoLancamento);
	}

	@Override
	public void validarLancamento(Lancamento lancamento) {
		//To do
	}

	@Override
	public LancamentoResponseDTO atualizaLancamento(LancamentoPutDTO lancamentoAtualizado, Long id) {
		
		return repository.findById(id)
				.map(lancamento -> {
					lancamento.setHorario(lancamentoAtualizado.getHorario());
				  repository.save(lancamento);
				 return mapper.modelToDto(lancamento) ;
				}).orElseThrow(() -> new LancamentoNotFound("Lancamento com o id + " + id + " não encontrado"));
	}

	@Override
	public List<LancamentoResponseDTO> findAll(Long idFuncionario) {
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		if(!funcionario.isPresent()) {
			throw new FuncionarioNotFound("Funcionáro com o id " + idFuncionario + " não encontrado");
		}
		
		List<Lancamento> lancamentos = repository.findByFuncionario(funcionario.get());
		return mapper.listModelToDto(lancamentos);
		
	}
	
}
