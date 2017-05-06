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

import br.com.invistatech.sucessows.model.CategoriaNivel3;
import br.com.invistatech.sucessows.service.CategoriaNivel3Service;

@Transactional
@RequestMapping("/categoria-nivel-3")
@CrossOrigin("*")	
@Controller
public class CategoriaNivel3Controller {
	@Autowired
	private CategoriaNivel3Service cn3Service;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel3> getCategoriaNivel3(@PathVariable("id") Long id){
		return new ResponseEntity<CategoriaNivel3>(cn3Service.getCategoriaNivel3(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaNivel3>> getListaCategoriaNivel3(){
		return new ResponseEntity<List<CategoriaNivel3>>(cn3Service.getListaCategoriaNivel3(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel3> save(@RequestBody CategoriaNivel3 catNivel3){
		return new ResponseEntity<CategoriaNivel3>(cn3Service.save(catNivel3), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaNivel3> edit(@RequestBody CategoriaNivel3 catNivel3){
		return new ResponseEntity<CategoriaNivel3>(cn3Service.alterar(catNivel3), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		System.out.println("id da categoria nivel 3:"+ id);
		cn3Service.deleta(id);
	}
}
