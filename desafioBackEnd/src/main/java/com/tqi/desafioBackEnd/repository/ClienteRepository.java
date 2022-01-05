package com.tqi.desafioBackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tqi.desafioBackEnd.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Optional<Cliente> findByEmail (String email);
	
	List<Cliente> findByNomeCompletoContainingIgnoreCase (String nomeCompleto);

}
