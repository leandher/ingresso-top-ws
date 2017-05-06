package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.ReferenciaComercial;
import br.com.invistatech.sucessows.repository.ReferenciaComercialRepository;

@Service
public class ReferenciaComercialService {
	@Autowired
	private ReferenciaComercialRepository referenciaComercialRepository;
	
	public List<ReferenciaComercial> getListaReferenciaComercial(){
		return referenciaComercialRepository.findAll();
	}
	
	public ReferenciaComercial getReferenciaComercial(Long id){
		return referenciaComercialRepository.findOne(id);
	}
	
	public ReferenciaComercial save(ReferenciaComercial referenciaComercial){
		return referenciaComercialRepository.save(referenciaComercial);
	}
	
	public ReferenciaComercial alterar(ReferenciaComercial referenciaComercial){
		return referenciaComercialRepository.save(referenciaComercial);
	}
	
	public void deleta(Long id){
		 referenciaComercialRepository.delete(id);
	}
	
	public List<ReferenciaComercial> getReferencias(Long id){
		return referenciaComercialRepository.getReferencias(id);
	}
}
