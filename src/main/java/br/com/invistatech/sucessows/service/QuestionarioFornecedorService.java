package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.QuestionarioFornecedor;
import br.com.invistatech.sucessows.repository.QuestionarioFornecedorRepository;

@Service
public class QuestionarioFornecedorService {
	@Autowired
	private QuestionarioFornecedorRepository questionarioFornecedorRepository;
	
	public List<QuestionarioFornecedor> getListaQuestionarioFornecedor(){
		return questionarioFornecedorRepository.findAll();
	}
	
	public QuestionarioFornecedor getQuestionarioFornecedor(Long id){
		return questionarioFornecedorRepository.findOne(id);
	}
	
	public QuestionarioFornecedor save(QuestionarioFornecedor questionarioFornecedor){
		return questionarioFornecedorRepository.save(questionarioFornecedor);
	}
	
	public QuestionarioFornecedor alterar(QuestionarioFornecedor questionarioFornecedor){
		return questionarioFornecedorRepository.save(questionarioFornecedor);
	}
	
	public void deleta(Long id){
		 questionarioFornecedorRepository.delete(id);
	}
	
	public List<QuestionarioFornecedor> getQuestionariosByFornecedor(Long id){
		return questionarioFornecedorRepository.getQuestionarios(id);
	}
}
