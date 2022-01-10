package com.tqi.desafioBackEnd.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tqi.desafioBackEnd.model.Cliente;
import com.tqi.desafioBackEnd.model.ClienteDTO;
import com.tqi.desafioBackEnd.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;

	public Optional<Object> cadastrarCliente(Cliente novoCliente) {
		return repositorio.findByEmail(novoCliente.getEmail()).map(clienteExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoCliente.getSenha());
			novoCliente.setSenha(senhaCriptografada);
			return Optional.ofNullable(repositorio.save(novoCliente));
		});
	}

	public Optional<?> pegarCredenciais(ClienteDTO clienteParaAutenticar) {
		return repositorio.findByEmail(clienteParaAutenticar.getEmail()).map(usuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(clienteParaAutenticar.getSenha(), usuarioExistente.getSenha())) {
				String estruturaBasic = clienteParaAutenticar.getEmail() + ":" + clienteParaAutenticar.getSenha();
				byte[] autorizacaoBase64 = Base64.encodeBase64(estruturaBasic.getBytes(Charset.forName("US-ASCII")));
				String autorizacaoHeader = "Basic " + new String(autorizacaoBase64);

				clienteParaAutenticar.setToken(autorizacaoHeader);
				clienteParaAutenticar.setId(usuarioExistente.getId());
				clienteParaAutenticar.setNomeCompleto(usuarioExistente.getNomeCompleto());
				clienteParaAutenticar.setSenha(usuarioExistente.getSenha());
				return Optional.ofNullable(clienteParaAutenticar);
			} else {
				return Optional.empty();
			}
		});

	}
}