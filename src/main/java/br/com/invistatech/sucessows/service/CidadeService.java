package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Cidade;
import br.com.invistatech.sucessows.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> getListaCidade(){
		return cidadeRepository.findAll();
	}
	
	public Cidade getCidade(Long id){
		return cidadeRepository.findOne(id);
	}
	
	public Cidade save(Cidade cidade){
		return cidadeRepository.save(cidade);
	}
	
	public Cidade alterar(Cidade cidade){
		return cidadeRepository.save(cidade);
	}
	
	public void deleta(Long id){
		 cidadeRepository.delete(id);
	}
}
