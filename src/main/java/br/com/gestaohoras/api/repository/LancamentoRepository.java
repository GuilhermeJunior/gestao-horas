package br.com.gestaohoras.api.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaohoras.api.model.Funcionario;
import br.com.gestaohoras.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	public Optional<Lancamento> findByFuncionarioAndData(Funcionario funcionario, LocalDate data);
	
	public List<Lancamento> findByFuncionario(Funcionario funcionario);
}
