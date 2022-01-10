package com.tqi.desafioBackEnd.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Solicitacao de Emprestimo")
public class SolicitacaoEmprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private BigDecimal valorEmprestimo;
	
	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrimeiraParcela = new java.sql.Date(System.currentTimeMillis());
	
	@NotBlank
	private Long quantidadeDeParcelas;
	
	@ManyToOne
	@JsonIgnoreProperties("Solicitacao de Emprestimo")
	private AcompanhamentoSolicitacaoEmprestimo acompanhamento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "minhasSolicitacoes" })
	private Cliente cliente;
	
	

	public AcompanhamentoSolicitacaoEmprestimo getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(AcompanhamentoSolicitacaoEmprestimo acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Date getDataPrimeiraParcela() {
		return dataPrimeiraParcela;
	}

	public void setDataPrimeiraParcela(Date dataPrimeiraParcela) {
		this.dataPrimeiraParcela = dataPrimeiraParcela;
	}

	public Long getQuantidadeDeParcelas() {
		return quantidadeDeParcelas;
	}

	public void setQuantidadeDeParcelas(Long quantidadeDeParcelas) {
		this.quantidadeDeParcelas = quantidadeDeParcelas ;
	}
	
	

}
