package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Socio;
import br.com.invistatech.sucessows.repository.SocioRepository;

@Service
public class SocioService {
	@Autowired
	private SocioRepository socioRepository;
	
	public List<Socio> getListaSocio(){
		return socioRepository.findAll();
	}
	
	public Socio getSocio(Long id){
		return socioRepository.findOne(id);
	}
	
	public Socio save(Socio socio){
		return socioRepository.save(socio);
	}
	
	public Socio alterar(Socio socio){
		return socioRepository.save(socio);
	}
	
	public void deleta(Long id){
		 socioRepository.delete(id);
	}
}
