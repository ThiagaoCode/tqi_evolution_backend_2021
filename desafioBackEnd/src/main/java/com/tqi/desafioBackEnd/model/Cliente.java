package com.tqi.desafioBackEnd.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table( name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "obrigatório nome completo")
	private String nomeCompleto;
	
	
	@Email(message = "obrigatório email")
	private String email;
	
	
	@NotBlank
	@Size (min = 5, max = 100, message = "minimo 5 caracteres")
	private String senha;
	
	
	@CPF
	@NotBlank
	private String CPF;
	
	
	
	@NotBlank
	@Size (min = 9, max = 9, message = "somente os números do RG")
	private String registroGeral;
	
	
	@NotBlank
	@Size (min = 9, max = 9, message = "somente os números")
	private String RG;
	
	
	
	@NotBlank
	@Size (min = 4, max = 200, message = "Endereço completo")
	private String endereco;
	
	@NotBlank
	private BigDecimal renda;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
	
	
	
	
	
	
	
	
	
	
	

}
