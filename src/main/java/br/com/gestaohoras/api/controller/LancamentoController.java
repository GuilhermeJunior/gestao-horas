package br.com.gestaohoras.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestaohoras.api.dto.LancamentoPostDTO;
import br.com.gestaohoras.api.dto.LancamentoPutDTO;
import br.com.gestaohoras.api.dto.LancamentoResponseDTO;
import br.com.gestaohoras.api.interfaces.LancamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {
	
	private final LancamentoService service;
	
	@PostMapping
	public ResponseEntity<LancamentoResponseDTO> adicionaLancamento(@Valid @RequestBody LancamentoPostDTO newLancamento){
		
		return new ResponseEntity<>(service.adicionaLancamento(newLancamento), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<LancamentoResponseDTO> atualizaLancamento(@Valid @RequestBody LancamentoPutDTO updatedLancamento, @PathVariable("id") Long id){
		
		return new ResponseEntity<>(service.atualizaLancamento(updatedLancamento, id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<LancamentoResponseDTO>> findAll(@RequestParam Long idFuncionario){
		return new ResponseEntity<>(service.findAll(idFuncionario), HttpStatus.OK);
	}
}
