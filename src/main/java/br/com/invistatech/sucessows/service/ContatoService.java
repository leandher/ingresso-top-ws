package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Contato;
import br.com.invistatech.sucessows.repository.ContatoRepository;

@Service
public class ContatoService {
	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<Contato> getListaContato(){
		return contatoRepository.findAll();
	}
	
	public Contato getContato(Long id){
		return contatoRepository.findOne(id);
	}
	
	public Contato save(Contato contato){
		return contatoRepository.save(contato);
	}
	
	public Contato alterar(Contato contato){
		return contatoRepository.save(contato);
	}
	
	public void deleta(Long id){
		 contatoRepository.delete(id);
	}
	
	public List<Contato> getContatoByFornecedor(Long id){
		return contatoRepository.getContatosByFornecedor(id);
	}
}
