package br.com.leandher.ingresso_top_ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandher.ingresso_top_ws.model.Cinema;
import br.com.leandher.ingresso_top_ws.repository.CinemaRepository;

@Service
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	public List<Cinema> getCinemas(){
		return cinemaRepository.findAll();
	}
	
	public Cinema getCinema(Long id){
		return cinemaRepository.findOne(id);
	}
	
	public Cinema save(Cinema cinema){
		return cinemaRepository.save(cinema);
	}
	
	public Cinema alterar(Cinema cinema){
		return cinemaRepository.save(cinema);
	}
	
	public void deleta(Long id){
		 cinemaRepository.delete(id);
	}
}
