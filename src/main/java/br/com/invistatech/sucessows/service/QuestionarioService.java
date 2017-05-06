package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Questionario;
import br.com.invistatech.sucessows.repository.QuestionarioRepository;

@Service
public class QuestionarioService {
	@Autowired
	private QuestionarioRepository questRepository;
	
	public List<Questionario> getListaQuestionario(){
		return questRepository.findAll();
	}
	public void cadastrar(Questionario questRep){
		questRepository.save(questRep);
	}
	public Questionario alterar(Questionario questRep){
		questRepository.save(questRep);
		return questRep;
	}
	public Questionario getQuestionario(Integer id) {
		return questRepository.findOne(id);
	}
	
	public Questionario save(Questionario questRep){
		 return questRepository.save(questRep);
	}
	
	public void deleta(Integer id){
		questRepository.delete(id);
	}
}
