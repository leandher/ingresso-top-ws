package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.NumeroFuncionario;
import br.com.invistatech.sucessows.repository.NumeroFuncionarioRepository;

@Service
public class NumeroFuncionarioService {
	
	@Autowired 
	private NumeroFuncionarioRepository nfRepository;
	
	public List<NumeroFuncionario> getListaNumeroFuncionario(){
		return nfRepository.findAll();
	}
	
	public NumeroFuncionario getNumeroFuncionario(Integer id){
		return nfRepository.findOne(id);
	}
	
	public NumeroFuncionario save(NumeroFuncionario numeroFuncionario){
		return nfRepository.save(numeroFuncionario);
	}
	
	public NumeroFuncionario alterar(NumeroFuncionario numeroFuncionario){
		return nfRepository.save(numeroFuncionario);
	}
	
	public void deleta(Integer id){
		 nfRepository.delete(id);
	}
}
