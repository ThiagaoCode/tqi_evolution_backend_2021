package com.tqi.desafioBackEnd.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.desafioBackEnd.model.Cliente;
import com.tqi.desafioBackEnd.repository.ClienteRepository;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repositorio;


	@Autowired
	private ClienteService servicos;  // AINDA NAO INSERIDO

	@PostMapping("/salvar")
	public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Cliente novoCliente) {
		Optional<Object> objetoCadastrado = servicos.cadastrarUsuario(novoCliente);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
	@PutMapping("/autenticar")
	public ResponseEntity<Object> pegarCredenciais(@Valid @RequestBody ClienteDTO loginSenha) {
		Optional<?> objetoCredenciado = servicos.pegarCredenciais(loginSenha);

		if (objetoCredenciado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCredenciado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
		
	}
	@GetMapping("/todes")
	public ResponseEntity<Object> buscarTodes() {
		List<Cliente> listaUsuarios = repositorio.findAll();
		
		if (listaUsuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaUsuarios);
		}
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(200).body(repositorio.findById(id).get());
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam(defaultValue = "") String nomeCompleto) {
		return ResponseEntity.status(200).body(repositorio.findByNomeCompletoContainingIgnoreCase(nomeCompleto));
	}
	
	
	@DeleteMapping("/deletar/{idUsuario}")
	public ResponseEntity<String> deletarPorId(@PathVariable Long idCliente) {
		Optional<Cliente> usuarioExistente = repositorio.findById(idCliente);
		if (usuarioExistente.isPresent()) {
			repositorio.deleteById(idCliente);
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
		
	}

}



