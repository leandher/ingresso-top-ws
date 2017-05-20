package br.com.leandher.ingresso_top_ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandher.ingresso_top_ws.model.Filme;
import br.com.leandher.ingresso_top_ws.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<Filme> getFilmes(){
		return filmeRepository.findAll();
	}
	
	public Filme getFilme(Long id){
		return filmeRepository.findOne(id);
	}
	
	public Filme save(Filme filme){
		return filmeRepository.save(filme);
	}
	
	public Filme alterar(Filme filme){
		return filmeRepository.save(filme);
	}
	
	public void deleta(Long id){
		 filmeRepository.delete(id);
	}
}
