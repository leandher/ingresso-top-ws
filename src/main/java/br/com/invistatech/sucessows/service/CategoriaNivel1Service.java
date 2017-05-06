package br.com.invistatech.sucessows.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import br.com.invistatech.sucessows.model.CategoriaNivel1;
import br.com.invistatech.sucessows.repository.CategoriaNivel1Repository;

@Service
public class CategoriaNivel1Service {
	@Autowired
	private CategoriaNivel1Repository cn1Repository;
	
	public List<CategoriaNivel1> getListaCategoriaNivel1(){
		return cn1Repository.findAll();
	}
	public void cadastrar(CategoriaNivel1 catNivel1){
		cn1Repository.save(catNivel1);
	}
	public CategoriaNivel1 alterar(CategoriaNivel1 catNivel1){
		cn1Repository.save(catNivel1);
		return catNivel1;
	}
	public CategoriaNivel1 getCategoriaNivel1(Long id) {
		return cn1Repository.findOne(id);
	}
	
	public CategoriaNivel1 save(CategoriaNivel1 catNivel1){
		 return cn1Repository.save(catNivel1);
	}
	
	public void deleta(Long id){
		cn1Repository.delete(id);
	}

}
