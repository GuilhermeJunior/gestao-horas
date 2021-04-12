package br.com.gestaohoras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaohoras.api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
