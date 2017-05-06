package br.com.invistatech.sucessows.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.invistatech.sucessows.model.Questionario;
import br.com.invistatech.sucessows.service.QuestionarioService;

@Transactional
@RequestMapping("/questionario")
@CrossOrigin("*")	
@Controller
public class QuestionarioController {

	@Autowired
	private QuestionarioService questService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Questionario> getQuestionario(@PathVariable("id") Integer id){
		return new ResponseEntity<Questionario>(questService.getQuestionario(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Questionario>> getListaQuestionario(){
		return new ResponseEntity<List<Questionario>>(questService.getListaQuestionario(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Questionario> save(@RequestBody Questionario quest){
		return new ResponseEntity<Questionario>(questService.save(quest), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Questionario> edit(@RequestBody Questionario quest){
		return new ResponseEntity<Questionario>(questService.alterar(quest), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		try{
			questService.deleta(id);
		}catch(DataIntegrityViolationException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
