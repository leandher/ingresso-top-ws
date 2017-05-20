package br.com.leandher.ingresso_top_ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandher.ingresso_top_ws.model.Sessao;
import br.com.leandher.ingresso_top_ws.repository.SessaoRepository;

@Service
public class SessaoService {
	@Autowired
	private SessaoRepository sessaoRepository;
	
	public List<Sessao> getSessoes(){
		return sessaoRepository.findAll();
	}
	
	public Sessao getSessao(Long id){
		return sessaoRepository.findOne(id);
	}
	
	public Sessao save(Sessao sessao){
		return sessaoRepository.save(sessao);
	}
	
	public Sessao alterar(Sessao sessao){
		return sessaoRepository.save(sessao);
	}
	
	public void deleta(Long id){
		 sessaoRepository.delete(id);
	}
}
