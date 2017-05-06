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

import br.com.invistatech.sucessows.model.Diretoria;
import br.com.invistatech.sucessows.service.DiretoriaService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/diretoria")
@Controller
public class DiretoriaController {
	@Autowired
	private DiretoriaService diretoriaService; 
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Diretoria> getDiretoria(@PathVariable("id") Long id){
		return new ResponseEntity<Diretoria>(diretoriaService.getDiretoria(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Diretoria>> getListaDiretoria(){
		return new ResponseEntity<List<Diretoria>>(diretoriaService.getListaDiretoria(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Diretoria> save(@RequestBody Diretoria diretoria){
		return new ResponseEntity<Diretoria>(diretoriaService.save(diretoria), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Diretoria> edit(@RequestBody Diretoria diretoria){
		return new ResponseEntity<Diretoria>(diretoriaService.alterar(diretoria), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Diretoria> delete(@PathVariable("id") Long id){
		diretoriaService.deleta(id);
		return new ResponseEntity<Diretoria>(HttpStatus.OK);
	}
}
