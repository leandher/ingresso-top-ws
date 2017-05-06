package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Porte;
import br.com.invistatech.sucessows.repository.PorteRepository;

@Service
public class PorteService {
	@Autowired
	private PorteRepository porteRepository;
	
	public List<Porte> getListaPorte(){
		return porteRepository.findAll();
	}
	
	public Porte getPorte(Integer id){
		return porteRepository.findOne(id);
	}
	
	public Porte save(Porte porte){
		return porteRepository.save(porte);
	}
	
	public Porte alterar(Porte porte){
		return porteRepository.save(porte);
	}
	
	public void deleta(Integer id){
		 porteRepository.delete(id);
	}
}
