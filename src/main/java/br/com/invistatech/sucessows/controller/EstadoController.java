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
import br.com.invistatech.sucessows.model.Estado;
import br.com.invistatech.sucessows.service.EstadoService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/estado")
@Controller
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> getEstado(@PathVariable("id") Long id){
		return new ResponseEntity<Estado>(estadoService.getEstado(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estado>> getListaEstado(){
		return new ResponseEntity<List<Estado>>(estadoService.getListaEstado(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> save(@RequestBody Estado estado){
		return new ResponseEntity<Estado>(estadoService.save(estado), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> edit(@RequestBody Estado estado){
		return new ResponseEntity<Estado>(estadoService.alterar(estado), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Estado> delete(@PathVariable("id") Long id){
		estadoService.deleta(id);
		return new ResponseEntity<Estado>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/cidades", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cidade>> getCidades(@PathVariable("id") Long id){
		return new ResponseEntity<List<Cidade>>(estadoService.getCidades(id), HttpStatus.OK);
	}
}
