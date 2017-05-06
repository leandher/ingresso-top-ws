package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.QuestionarioAvaliacao;
import br.com.invistatech.sucessows.repository.QuestionarioAvaliacaoRepository;

@Service
public class QuestionarioAvaliacaoService {
	@Autowired
	private QuestionarioAvaliacaoRepository questAvRepository;
	
	public List<QuestionarioAvaliacao> getListaQuestionarioAvaliacao(){
		return questAvRepository.findAll();
	}
	public void cadastrar(QuestionarioAvaliacao questRep){
		questAvRepository.save(questRep);
	}
	public QuestionarioAvaliacao alterar(QuestionarioAvaliacao questRep){
		questAvRepository.save(questRep);
		return questRep;
	}
	public QuestionarioAvaliacao getQuestionarioAvaliacao(Long id) {
		return questAvRepository.findOne(id);
	}
	
	public QuestionarioAvaliacao save(QuestionarioAvaliacao questRep){
		 return questAvRepository.save(questRep);
	}
	
	public void deleta(Long id){
		questAvRepository.delete(id);
	}
}
