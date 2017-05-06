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

import br.com.invistatech.sucessows.model.AnexoFornecedor;
import br.com.invistatech.sucessows.service.AnexoFornecedorService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/anexo-fornecedor")
@Controller
public class AnexoFornecedorController {
	@Autowired
	private AnexoFornecedorService anexoFornecedorService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnexoFornecedor> getAnexoFornecedor(@PathVariable("id") Long id){
		return new ResponseEntity<AnexoFornecedor>(anexoFornecedorService.getAnexoFornecedor(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnexoFornecedor>> getListaAnexoFornecedor(){
		return new ResponseEntity<List<AnexoFornecedor>>(anexoFornecedorService.getListaAnexoFornecedor(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnexoFornecedor> save(@RequestBody AnexoFornecedor anexoFornecedor){
		return new ResponseEntity<AnexoFornecedor>(anexoFornecedorService.save(anexoFornecedor), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnexoFornecedor> edit(@RequestBody AnexoFornecedor anexoFornecedor){
		return new ResponseEntity<AnexoFornecedor>(anexoFornecedorService.alterar(anexoFornecedor), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<AnexoFornecedor> delete(@PathVariable("id") Long id){
		anexoFornecedorService.deleta(id);
		return new ResponseEntity<AnexoFornecedor>(HttpStatus.OK);
	}
}
