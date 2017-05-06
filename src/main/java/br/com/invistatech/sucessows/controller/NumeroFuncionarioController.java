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

import br.com.invistatech.sucessows.model.NumeroFuncionario;
import br.com.invistatech.sucessows.service.NumeroFuncionarioService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/numero-funcionario")
@Controller
public class NumeroFuncionarioController {

	@Autowired
	private NumeroFuncionarioService nfService;
	

	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NumeroFuncionario> getNumeroFuncionario(@PathVariable("id") Integer id){
		return new ResponseEntity<NumeroFuncionario>(nfService.getNumeroFuncionario(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NumeroFuncionario>> getListaNumeroFuncionario(){
		return new ResponseEntity<List<NumeroFuncionario>>(nfService.getListaNumeroFuncionario(), HttpStatus.OK); 
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NumeroFuncionario> save(@RequestBody NumeroFuncionario numeroFuncionario){
		return new ResponseEntity<NumeroFuncionario>(nfService.save(numeroFuncionario), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NumeroFuncionario> alterar(@RequestBody NumeroFuncionario numeroFuncionario){
		return new ResponseEntity<NumeroFuncionario>(nfService.alterar(numeroFuncionario), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<NumeroFuncionario> deleta(@PathVariable("id") Integer id){
		nfService.deleta(id);
		return new ResponseEntity<NumeroFuncionario>(HttpStatus.OK);
	}
}
