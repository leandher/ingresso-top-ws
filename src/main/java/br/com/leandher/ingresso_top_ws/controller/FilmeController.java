package br.com.leandher.ingresso_top_ws.controller;

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

import br.com.leandher.ingresso_top_ws.model.Filme;
import br.com.leandher.ingresso_top_ws.service.FilmeService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/filme")
@Controller
public class FilmeController {

	@Autowired
	private FilmeService filmeService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> getFilme(@PathVariable("id") Long id){
		return new ResponseEntity<Filme>(filmeService.getFilme(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Filme>> getListaFilme(){
		return new ResponseEntity<List<Filme>>(filmeService.getFilmes(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> save(@RequestBody Filme filme){
		return new ResponseEntity<Filme>(filmeService.save(filme), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> edit(@RequestBody Filme filme){
		return new ResponseEntity<Filme>(filmeService.alterar(filme), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Filme> delete(@PathVariable("id") Long id){
		filmeService.deleta(id);
		return new ResponseEntity<Filme>(HttpStatus.OK);
	}

}
