package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.invistatech.sucessows.model.Cnae;
import br.com.invistatech.sucessows.repository.CnaeRepository;

@Service
public class CnaeService {
	@Autowired
	private CnaeRepository cnaeRepository;
	
	public List<Cnae> getListaCnae(){
		return cnaeRepository.findAll();
	}
	public void cadastrar(Cnae cnae){
		cnaeRepository.save(cnae);
	}
	public Cnae alterar(Cnae cnae){
		return cnaeRepository.save(cnae);
	}
	public Cnae getCnae(Integer id) {
		return cnaeRepository.findOne(id);
	}
	
	public Cnae save(Cnae cnae){
		 return cnaeRepository.save(cnae);
	}
	
	public void deleta(int id){
		 cnaeRepository.delete(id);
	}

}
