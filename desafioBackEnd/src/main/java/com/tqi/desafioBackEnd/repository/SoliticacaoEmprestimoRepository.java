package com.tqi.desafioBackEnd.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tqi.desafioBackEnd.model.SolicitacaoEmprestimo;



public interface SoliticacaoEmprestimoRepository extends JpaRepository<SolicitacaoEmprestimo, Long> {
	public List<SolicitacaoEmprestimo> findAllByValorEmprestimoContainingIgnoreCase (BigDecimal valorEmprestimo);



}