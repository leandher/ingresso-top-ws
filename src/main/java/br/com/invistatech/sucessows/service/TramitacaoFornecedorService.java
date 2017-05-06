package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.TramitacaoFornecedor;
import br.com.invistatech.sucessows.repository.TramitacaoFornecedorRepository;

@Service
public class TramitacaoFornecedorService {
	@Autowired
	private TramitacaoFornecedorRepository tramitacaoFornecedorRepository;
	
	public List<TramitacaoFornecedor> getListaTramitacaoFornecedor(){
		return tramitacaoFornecedorRepository.findAll();
	}
	
	public TramitacaoFornecedor getTramitacaoFornecedor(Long id){
		return tramitacaoFornecedorRepository.findOne(id);
	}
	
	public TramitacaoFornecedor save(TramitacaoFornecedor tramitacaoFornecedor){
		return tramitacaoFornecedorRepository.save(tramitacaoFornecedor);
	}
	
	public TramitacaoFornecedor alterar(TramitacaoFornecedor tramitacaoFornecedor){
		return tramitacaoFornecedorRepository.save(tramitacaoFornecedor);
	}
	
	public void deleta(Long id){
		 tramitacaoFornecedorRepository.delete(id);
	}
}
