package com.challenge.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.ClienteDTO;
import com.challenge.entities.Cliente;
import com.challenge.entities.Contato;
import com.challenge.repositories.ClienteRepository;
import com.challenge.repositories.ContatoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ContatoRepository contatoRepository;
	
	 public ClienteDTO findById(Long id) {
		 Cliente entity = repository.findById(id).get(); 
		 
		 ClienteDTO dto = new ClienteDTO(entity);
		 
		 return dto;
	 }
	
	 
	 public List<ClienteDTO> listClientes(){
		 List<Cliente> clientes = repository.findAll();
		 List<ClienteDTO> clisDto = new ArrayList<>(); 
		 for(Cliente cli : clientes)
			 clisDto.add(new ClienteDTO(cli));
				 
		 return clisDto;
	 }
	 
	public List<ClienteDTO> pesquisaClientes(String nome){
		 List<Cliente> clientes = repository.findByNome(nome);
		 List<ClienteDTO> clisDto = new ArrayList<>(); 
		 for(Cliente cli : clientes)
			 clisDto.add(new ClienteDTO(cli));
				 
		 return clisDto;
		
	}

	 
	 public ClienteDTO insert(Cliente cliente) {
		 LocalDate lt = LocalDate.now();
		 
		 Contato contato = contatoRepository.save(cliente.getContato());
		 
		 cliente.setContato(contato);
		 cliente.setDataCadastro(lt.toString());
		 
		 Cliente cli = repository.save(cliente);
		 
		 ClienteDTO cliDto = new ClienteDTO(cli);
		
		 return cliDto;
		
	 }
	
	 public ClienteDTO update(Long id, Cliente cliente) {
			Cliente cli = repository.findById(id).get();
			
			cli.setNome(cliente.getNome());
			cli.setDataCadastro(cliente.getDataCadastro());
			
			repository.save(cli);
			
			ClienteDTO cliDto = new ClienteDTO(cli);
			
			return cliDto;
			
	 }
	 
	 public boolean delete(Long id) {
		 	 
		 Cliente cli = repository.findById(id).get();
		 
		 repository.deleteById(id);
		 
		 contatoRepository.deleteById(cli.getContato().getId());
		 
		 return true;
	 }
	 
	 
}
