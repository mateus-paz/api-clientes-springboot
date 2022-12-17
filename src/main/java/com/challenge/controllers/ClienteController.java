package com.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.ClienteDTO;
import com.challenge.entities.Cliente;
import com.challenge.services.ClienteService;

@RestController
@RequestMapping(value = "/api/Clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<ClienteDTO> listClientes() {
		return service.listClientes();

	}
	
	@GetMapping(value = "/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/query/{nome}")
	public List<ClienteDTO> pesquisaClientes(@PathVariable String nome){
		return service.pesquisaClientes(nome);
	}
	
	@PostMapping
	public ClienteDTO insert(@RequestBody Cliente cliente) {
		
		ClienteDTO clienteDto = service.insert(cliente); 
		return clienteDto;
	}
	
	@PutMapping(value="/{id}")
	public ClienteDTO update(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		ClienteDTO clienteDto = service.update(id, cliente);
		
		return clienteDto;
	}
	

	@DeleteMapping(value ="/{id}")
	public boolean delete(@PathVariable("id") long id) {
		
		return service.delete(id);
		
	}
	
}
