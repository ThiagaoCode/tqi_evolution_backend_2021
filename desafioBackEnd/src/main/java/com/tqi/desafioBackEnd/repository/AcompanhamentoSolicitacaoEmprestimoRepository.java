package com.tqi.desafioBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tqi.desafioBackEnd.model.AcompanhamentoSolicitacaoEmprestimo;



@Repository
public interface AcompanhamentoSolicitacaoEmprestimoRepository extends JpaRepository<AcompanhamentoSolicitacaoEmprestimo, Long> {
	public List<AcompanhamentoSolicitacaoEmprestimo> findAllBySolicitacoesContainingIgnoreCase (Long solicitacoes);
}