package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model. PrazoPagamento;
import br.com.invistatech.sucessows.repository. PrazoPagamentoRepository;

@Service
public class PrazoPagamentoService {

	@Autowired
	private  PrazoPagamentoRepository prazoPagamentoRepository;
	
	public List< PrazoPagamento> getListaPrazoPagamento(){
		return prazoPagamentoRepository.findAll();
	}
	
	public  PrazoPagamento getPrazoPagamento(Integer id){
		return prazoPagamentoRepository.findOne(id);
	}
	
	public  PrazoPagamento save(PrazoPagamento prazoPagamento){
		return prazoPagamentoRepository.save(prazoPagamento);
	}
	
	public  PrazoPagamento alterar(PrazoPagamento prazoPagamento){
		return prazoPagamentoRepository.save(prazoPagamento);
	}
	
	public void deleta(Integer id){
		 prazoPagamentoRepository.delete(id);
	}
}
