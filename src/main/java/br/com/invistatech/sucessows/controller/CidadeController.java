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

import br.com.invistatech.sucessows.model.Cidade;
import br.com.invistatech.sucessows.service.CidadeService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/cidade")
@Controller
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cidade> getCidade(@PathVariable("id") Long id){
		return new ResponseEntity<Cidade>(cidadeService.getCidade(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cidade>> getListaCidade(){
		return new ResponseEntity<List<Cidade>>(cidadeService.getListaCidade(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cidade> save(@RequestBody Cidade cidade){
		return new ResponseEntity<Cidade>(cidadeService.save(cidade), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cidade> edit(@RequestBody Cidade cidade){
		return new ResponseEntity<Cidade>(cidadeService.alterar(cidade), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Cidade> delete(@PathVariable("id") Long id){
		cidadeService.deleta(id);
		return new ResponseEntity<Cidade>(HttpStatus.OK);
	}
}
