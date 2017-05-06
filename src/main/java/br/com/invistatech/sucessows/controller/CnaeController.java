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

import br.com.invistatech.sucessows.model.Cnae;
import br.com.invistatech.sucessows.service.CnaeService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/cnae")
@Controller
public class CnaeController {
	@Autowired
	private CnaeService cnaeService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cnae> getCnae(@PathVariable("id") Integer id){
		return new ResponseEntity<Cnae>(cnaeService.getCnae(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cnae>> getListaCnae(){
		return new ResponseEntity<List<Cnae>>(cnaeService.getListaCnae(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cnae> save(@RequestBody Cnae cnae){
		return new ResponseEntity<Cnae>(cnaeService.save(cnae), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cnae> edit(@RequestBody Cnae cnae){
		return new ResponseEntity<Cnae>(cnaeService.alterar(cnae), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Cnae> delete(@PathVariable("id") Integer id){
		cnaeService.deleta(id);
		return new ResponseEntity<Cnae>(HttpStatus.OK);
	}
}
