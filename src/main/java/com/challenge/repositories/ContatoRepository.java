package com.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
