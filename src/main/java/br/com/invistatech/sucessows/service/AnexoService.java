package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Anexo;
import br.com.invistatech.sucessows.repository.AnexoRepository;

@Service
public class AnexoService {
	
	@Autowired
	private AnexoRepository anexoRepository;
	
	public List<Anexo> getListaAnexo(){
		return anexoRepository.findAll();
	}
	
	public Anexo getAnexo(Integer id){
		return anexoRepository.findOne(id);
	}
	
	public Anexo save(Anexo anexo){
		return anexoRepository.save(anexo);
	}
	
	public Anexo alterar(Anexo anexo){
		return anexoRepository.save(anexo);
	}
	
	public void deleta(Integer id){
		 anexoRepository.delete(id);
	}
}
