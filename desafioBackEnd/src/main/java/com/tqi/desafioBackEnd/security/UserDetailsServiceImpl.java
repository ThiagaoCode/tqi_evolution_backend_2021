package com.tqi.desafioBackEnd.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tqi.desafioBackEnd.model.Cliente;
import com.tqi.desafioBackEnd.repository.ClienteRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository repositorio;
	@Override
	public UserDetails loadUserByUsername(String userName)  throws UsernameNotFoundException {
		Optional<Cliente> user = repositorio.findByEmail(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		
		
		return user.map(UserDetailsImpl::new).get();
	}
	
	

}