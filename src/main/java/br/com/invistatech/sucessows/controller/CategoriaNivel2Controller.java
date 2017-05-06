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

import br.com.invistatech.sucessows.model.CategoriaNivel2;
import br.com.invistatech.sucessows.model.CategoriaNivel3;
import br.com.invistatech.sucessows.service.CategoriaNivel2Service;
import br.com.invistatech.sucessows.service.CategoriaNivel3Service;

@Transactional
@RequestMapping("/categoria-nivel-2")
@CrossOrigin("*")	
@Controller
public class CategoriaNivel2Controller {
	@Autowired
	private CategoriaNivel2Service cn2Service;
	
	@Autowired
	private CategoriaNivel3Service cn3Service;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel2> getCategoriaNivel2(@PathVariable("id") Long id){
		return new ResponseEntity<CategoriaNivel2>(cn2Service.getCategoriaNivel2(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaNivel2>> getListaCategoriaNivel2(){
		return new ResponseEntity<List<CategoriaNivel2>>(cn2Service.getListaCategoriaNivel2(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}/categoria-nivel-3" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaNivel3>> getListaCatNivel3PorN2(@PathVariable("id") Long id){
		return new ResponseEntity<List<CategoriaNivel3>>(cn3Service.getListaCatNivel3PorN2(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel2> save(@RequestBody CategoriaNivel2 catNivel2){
		return new ResponseEntity<CategoriaNivel2>(cn2Service.save(catNivel2), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel2> edit(@RequestBody CategoriaNivel2 catNivel2){
		return new ResponseEntity<CategoriaNivel2>(cn2Service.alterar(catNivel2), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		cn2Service.deleta(id);
	}

}
