package br.com.gestaohoras.api.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.gestaohoras.api.model.Funcionario;
import br.com.gestaohoras.api.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Inserindo Funcionários");
		
		funcionarioRepository.save(new Funcionario(null, "3709", "Guilherme G. Chamorro Junior"));
		funcionarioRepository.save(new Funcionario(null, "21565", "Joe Doe"));
	}

}
