package br.com.invistatech.sucessows.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.invistatech.sucessows.model.CategoriaNivel1;
import br.com.invistatech.sucessows.model.CategoriaNivel2;
import br.com.invistatech.sucessows.service.CategoriaNivel1Service;
import br.com.invistatech.sucessows.service.CategoriaNivel2Service;

@Transactional
@RequestMapping("/categoria-nivel-1")
@CrossOrigin("*")	
@Controller
public class CategoriaNivel1Controller {
	@Autowired
	private CategoriaNivel1Service cn1Service;
	@Autowired
	private CategoriaNivel2Service cn2Service;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel1> getCategoriaNivel1(@PathVariable("id") Long id){
		return new ResponseEntity<CategoriaNivel1>(cn1Service.getCategoriaNivel1(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaNivel1>> getListaCategoriaNivel1(){
		return new ResponseEntity<List<CategoriaNivel1>>(cn1Service.getListaCategoriaNivel1(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}/categoria-nivel-2" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaNivel2>> getListaCatNivel2PorN1(@PathVariable("id") Long id){
		return new ResponseEntity<List<CategoriaNivel2>>(cn2Service.getListaCatNivel2PorN1(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel1> save(@RequestBody CategoriaNivel1 catNivel1){
		return new ResponseEntity<CategoriaNivel1>(cn1Service.save(catNivel1), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel1> edit(@RequestBody CategoriaNivel1 catNivel1){
		return new ResponseEntity<CategoriaNivel1>(cn1Service.alterar(catNivel1), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<CategoriaNivel1> delete(@PathVariable("id") Long id){
		cn1Service.deleta(id);
		return new ResponseEntity<CategoriaNivel1>(HttpStatus.OK);
	}
	
}
