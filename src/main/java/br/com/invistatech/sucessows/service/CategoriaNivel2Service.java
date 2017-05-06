package br.com.invistatech.sucessows.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import br.com.invistatech.sucessows.model.CategoriaNivel2;
import br.com.invistatech.sucessows.repository.CategoriaNivel2Repository;

@Service
public class CategoriaNivel2Service {
	@Autowired
	private CategoriaNivel2Repository cn2Repository;
	
	public List<CategoriaNivel2> getListaCategoriaNivel2(){
		return cn2Repository.findAll();
	}
	
	public List<CategoriaNivel2> getListaCatNivel2PorN1(Long nivel1){
		return cn2Repository.getListaCatNivel2PorN1(nivel1);
	}
	
	public void cadastrar(CategoriaNivel2 catNivel2){
		cn2Repository.save(catNivel2);
	}
	public CategoriaNivel2 alterar(CategoriaNivel2 catNivel2){
		cn2Repository.save(catNivel2);
		return catNivel2;
	}
	public CategoriaNivel2 getCategoriaNivel2(Long id) {
		return cn2Repository.findOne(id);
	}
	
	public CategoriaNivel2 save(CategoriaNivel2 catNivel2){
		 return cn2Repository.save(catNivel2);
	}
	
	public void deleta(Long id){
		cn2Repository.delete(id);
	}
}
