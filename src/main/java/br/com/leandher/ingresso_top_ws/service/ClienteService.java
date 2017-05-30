package br.com.leandher.ingresso_top_ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandher.ingresso_top_ws.model.Cliente;
import br.com.leandher.ingresso_top_ws.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente getCliente(Long id){
		return clienteRepository.findOne(id);
	}
	
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public Cliente alterar(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public void deleta(Long id){
		 clienteRepository.delete(id);
	}
	
	public Cliente login(Cliente c){
		return clienteRepository.login(c.getEmail(), c.getSenha());
	}
}
