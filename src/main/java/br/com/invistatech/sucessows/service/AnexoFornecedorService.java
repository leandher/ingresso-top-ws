package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.AnexoFornecedor;
import br.com.invistatech.sucessows.repository.AnexoFornecedorRepository;

@Service
public class AnexoFornecedorService {
	@Autowired
	private AnexoFornecedorRepository anexoFornecedorRepository;
	
	public List<AnexoFornecedor> getListaAnexoFornecedor(){
		return anexoFornecedorRepository.findAll();
	}
	
	public AnexoFornecedor getAnexoFornecedor(Long id){
		return anexoFornecedorRepository.findOne(id);
	}
	
	public AnexoFornecedor save(AnexoFornecedor anexoFornecedor){
		return anexoFornecedorRepository.save(anexoFornecedor);
	}
	
	public AnexoFornecedor alterar(AnexoFornecedor anexoFornecedor){
		return anexoFornecedorRepository.save(anexoFornecedor);
	}
	
	public void deleta(Long id){
		 anexoFornecedorRepository.delete(id);
	}
}
