package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Diretoria;
import br.com.invistatech.sucessows.repository.DiretoriaRepository;

@Service
public class DiretoriaService {
	@Autowired
	private DiretoriaRepository diretoriaRepository;
	
	public List<Diretoria> getListaDiretoria(){
		return diretoriaRepository.findAll();
	}
	
	public Diretoria getDiretoria(Long id){
		return diretoriaRepository.findOne(id);
	}
	
	public Diretoria save(Diretoria diretoria){
		return diretoriaRepository.save(diretoria);
	}
	
	public Diretoria alterar(Diretoria diretoria){
		return diretoriaRepository.save(diretoria);
	}
	
	public void deleta(Long id){
		 diretoriaRepository.delete(id);
	}
}
