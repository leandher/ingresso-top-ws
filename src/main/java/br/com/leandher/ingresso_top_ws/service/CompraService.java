package br.com.leandher.ingresso_top_ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandher.ingresso_top_ws.model.Compra;
import br.com.leandher.ingresso_top_ws.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	public List<Compra> getCompras(){
		return compraRepository.findAll();
	}
	
	public Compra getCompra(Long id){
		return compraRepository.findOne(id);
	}
	
	public Compra save(Compra compra){
		return compraRepository.save(compra);
	}
	
	public Compra alterar(Compra compra){
		return compraRepository.save(compra);
	}
	
	public void deleta(Long id){
		 compraRepository.delete(id);
	}
}
