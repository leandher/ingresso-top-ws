package br.com.invistatech.sucessows.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.invistatech.sucessows.model.QuestionarioAvaliacao;
import br.com.invistatech.sucessows.service.QuestionarioAvaliacaoService;

@Transactional
@RequestMapping("/questionario-avaliacao")
@CrossOrigin("*")	
@Controller
public class QuestionarioAvaliacaoController {
	@Autowired
	private QuestionarioAvaliacaoService questAvService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<QuestionarioAvaliacao> getQuestionarioAvaliacao(@PathVariable("id") Long id){
		return new ResponseEntity<QuestionarioAvaliacao>(questAvService.getQuestionarioAvaliacao(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<QuestionarioAvaliacao>> getListaQuestionarioAvaliacao(){
		return new ResponseEntity<List<QuestionarioAvaliacao>>(questAvService.getListaQuestionarioAvaliacao(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<QuestionarioAvaliacao> save(@RequestBody QuestionarioAvaliacao quest){
		return new ResponseEntity<QuestionarioAvaliacao>(questAvService.save(quest), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<QuestionarioAvaliacao> edit(@RequestBody QuestionarioAvaliacao quest){
		return new ResponseEntity<QuestionarioAvaliacao>(questAvService.alterar(quest), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<QuestionarioAvaliacao> delete(@PathVariable("id") Long id){
		System.out.println("id do questionario:"+ id);
		questAvService.deleta(id);
		return new ResponseEntity<QuestionarioAvaliacao>(HttpStatus.OK);
	}
}
