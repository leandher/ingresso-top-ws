package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Cidade;
import br.com.invistatech.sucessows.model.Estado;
import br.com.invistatech.sucessows.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> getListaEstado(){
		return estadoRepository.findAll();
	}
	
	public List<Cidade> getCidades(Long id){
		return estadoRepository.getCidades(id);
	}
	
	public Estado getEstado(Long id){
		return estadoRepository.findOne(id);
	}
	
	public Estado save(Estado estado){
		return estadoRepository.save(estado);
	}
	
	public Estado alterar(Estado estado){
		return estadoRepository.save(estado);
	}
	
	public void deleta(Long id){
		 estadoRepository.delete(id);
	}
}
