package com.tqi.desafioBackEnd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Acompanhamento das Solicitacao de Emprestimo")
public class AcompanhamentoSolicitacaoEmprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	
	@OneToMany(mappedBy = "Acompanhamento das Solicitacao de Emprestimo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Acompanhamento das Solicitacao de Emprestimo")
	private List<SolicitacaoEmprestimo> solicitacoes;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<SolicitacaoEmprestimo> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoEmprestimo> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	
	

}
