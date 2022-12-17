package com.challenge.dto;

import com.challenge.entities.Cliente;
import com.challenge.entities.Contato;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String dataCadastro;
	private Contato contato;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Long id, String nome, String dataCadastro, Contato contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.contato = contato;
	}


	public ClienteDTO(Cliente cliente){
		id = cliente.getId();
		nome = cliente.getNome();
		dataCadastro = cliente.getDataCadastro();
		contato = cliente.getContato();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
