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

import br.com.invistatech.sucessows.model.Anexo;
import br.com.invistatech.sucessows.service.AnexoService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/anexo")
@Controller
public class AnexoController {

	@Autowired
	private AnexoService anexoService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Anexo> getAnexo(@PathVariable("id") Integer id){
		return new ResponseEntity<Anexo>(anexoService.getAnexo(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Anexo>> getListaAnexo(){
		return new ResponseEntity<List<Anexo>>(anexoService.getListaAnexo(), HttpStatus.OK); 
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Anexo> save(@RequestBody Anexo anexo){
		return new ResponseEntity<Anexo>(anexoService.save(anexo), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Anexo> alterar(@RequestBody Anexo anexo){
		return new ResponseEntity<Anexo>(anexoService.alterar(anexo), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Anexo> deleta(@PathVariable("id") Integer id){
		anexoService.deleta(id);
		return new ResponseEntity<Anexo>(HttpStatus.OK);
	}
}
