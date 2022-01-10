package com.tqi.desafioBackEnd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String cpf;
	
	
	
	@NotBlank
	@Size (min = 9, max = 9, message = "somente os números do RG")
	private String registroGeral;
	
	
		
	
	@NotBlank
	@Size (min = 4, max = 200, message = "Endereço completo")
	private String endereco;
	
	@NotBlank
	private BigDecimal renda;
	
	
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"cliente"})
	private List<SolicitacaoEmprestimo> minhasSolicitacoesDeEmprestimo = new ArrayList<>();
	
	
	
	
	

	public List<SolicitacaoEmprestimo> getMinhasSolicitacoesDeEmprestimo() {
		return minhasSolicitacoesDeEmprestimo;
	}




	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public Cliente(Long id, String nomeCompleto, String email, String senha, String cpf, String registroGeral,  String endereco, BigDecimal renda) {
		
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.registroGeral = registroGeral;
		this.endereco = endereco;
		this.renda = renda;
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




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public String getRegistroGeral() {
		return registroGeral;
	}




	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
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




	public void setMinhasSolicitacoesDeEmprestimo(List<SolicitacaoEmprestimo> minhasSolicitacoesDeEmprestimo) {
		this.minhasSolicitacoesDeEmprestimo = minhasSolicitacoesDeEmprestimo;
	}




	
	
	
	
	
	

}
