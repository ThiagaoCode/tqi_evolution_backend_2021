package com.tqi.desafioBackEnd.controller;

import java.math.BigDecimal;
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

import com.tqi.desafioBackEnd.model.SolicitacaoEmprestimo;
import com.tqi.desafioBackEnd.repository.SoliticacaoEmprestimoRepository;


@RestController
@RequestMapping("/Solicitacoes")
@CrossOrigin("*")
public class SolicitacaoEmprestimoController {
	
	@Autowired
	private SoliticacaoEmprestimoRepository repository;

	@GetMapping
	public ResponseEntity<List<SolicitacaoEmprestimo>> GetAll() {
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SolicitacaoEmprestimo> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<SolicitacaoEmprestimo>> GetByTitulo(@PathVariable BigDecimal valorEmprestimo) {
		return ResponseEntity.ok(repository.findAllByValorEmprestimoContainingIgnoreCase(valorEmprestimo));
	}
	
	
	@PostMapping("/solicitacao")
	public ResponseEntity<SolicitacaoEmprestimo> post(@RequestBody SolicitacaoEmprestimo valorEmprestimo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(valorEmprestimo));
	}
	
	

	@PutMapping 
	public ResponseEntity<SolicitacaoEmprestimo> put(@RequestBody SolicitacaoEmprestimo valorEmprestimo){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(valorEmprestimo));
		
	}
	
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
		
	
	
	
}
