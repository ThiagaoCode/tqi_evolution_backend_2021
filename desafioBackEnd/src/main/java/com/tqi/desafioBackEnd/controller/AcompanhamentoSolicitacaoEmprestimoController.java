package com.tqi.desafioBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.desafioBackEnd.model.AcompanhamentoSolicitacaoEmprestimo;
import com.tqi.desafioBackEnd.repository.AcompanhamentoSolicitacaoEmprestimoRepository;

@RestController
@RequestMapping("/acompanhamento")
@CrossOrigin("*")
public class AcompanhamentoSolicitacaoEmprestimoController {
	
	@Autowired
	private AcompanhamentoSolicitacaoEmprestimoRepository repository;

	@GetMapping
	public ResponseEntity<List<AcompanhamentoSolicitacaoEmprestimo>> GetAll() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AcompanhamentoSolicitacaoEmprestimo> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).build());
	}

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<AcompanhamentoSolicitacaoEmprestimo>> GetByCategoria(@PathVariable Long solicitacoes) {
		return ResponseEntity.ok(repository.findAllBySolicitacoesContainingIgnoreCase(solicitacoes));
	}

	@PostMapping
	public ResponseEntity<AcompanhamentoSolicitacaoEmprestimo> post(@RequestBody AcompanhamentoSolicitacaoEmprestimo solicitacoes) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(solicitacoes));
	}

	@PutMapping 
	public ResponseEntity<AcompanhamentoSolicitacaoEmprestimo>put(@RequestBody AcompanhamentoSolicitacaoEmprestimo solicitacoes){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(solicitacoes));
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	


}
