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

import br.com.invistatech.sucessows.model.Porte;
import br.com.invistatech.sucessows.service.PorteService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/porte")
@Controller
public class PorteController {

	@Autowired
	private PorteService porteService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Porte> getPorte(@PathVariable("id") Integer id){
		return new ResponseEntity<Porte>(porteService.getPorte(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Porte>> getListaPorte(){
		return new ResponseEntity<List<Porte>>(porteService.getListaPorte(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Porte> save(@RequestBody Porte porte){
		return new ResponseEntity<Porte>(porteService.save(porte), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Porte> edit(@RequestBody Porte porte){
		return new ResponseEntity<Porte>(porteService.alterar(porte), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Porte> delete(@PathVariable("id") Integer id){
		porteService.deleta(id);
		return new ResponseEntity<Porte>(HttpStatus.OK);
	}
}
