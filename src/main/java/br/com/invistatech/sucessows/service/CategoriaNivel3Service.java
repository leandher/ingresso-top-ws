package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.CategoriaNivel3;
import br.com.invistatech.sucessows.repository.CategoriaNivel3Repository;

@Service
public class CategoriaNivel3Service {
	@Autowired
	private CategoriaNivel3Repository cn3Repository;
	
	public List<CategoriaNivel3> getListaCategoriaNivel3(){
		return cn3Repository.findAll();
	}
	public void cadastrar(CategoriaNivel3 catNivel3){
		cn3Repository.save(catNivel3);
	}
	public CategoriaNivel3 alterar(CategoriaNivel3 catNivel3){
		cn3Repository.save(catNivel3);
		return catNivel3;
	}
	public CategoriaNivel3 getCategoriaNivel3(Long id) {
		return cn3Repository.findOne(id);
	}
	
	public CategoriaNivel3 save(CategoriaNivel3 catNivel3){
		 return cn3Repository.save(catNivel3);
	}
	
	public void deleta(Long id){
		cn3Repository.delete(id);
	}
	
	public List<CategoriaNivel3> getListaCatNivel3PorN2(Long nivel2){
		return cn3Repository.getListaCatNivel3PorN2(nivel2);
	}
}
