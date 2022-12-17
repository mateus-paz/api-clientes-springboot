package com.challenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	  List<Cliente> findByNome(String nome);
	
}
