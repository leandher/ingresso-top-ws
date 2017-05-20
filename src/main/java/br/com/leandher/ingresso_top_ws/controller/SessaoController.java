package br.com.leandher.ingresso_top_ws.controller;

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

import br.com.leandher.ingresso_top_ws.model.Sessao;
import br.com.leandher.ingresso_top_ws.service.SessaoService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/sessao")
@Controller
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sessao> getSessao(@PathVariable("id") Long id){
		return new ResponseEntity<Sessao>(sessaoService.getSessao(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sessao>> getListaSessao(){
		return new ResponseEntity<List<Sessao>>(sessaoService.getSessoes(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sessao> save(@RequestBody Sessao sessao){
		return new ResponseEntity<Sessao>(sessaoService.save(sessao), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sessao> edit(@RequestBody Sessao sessao){
		return new ResponseEntity<Sessao>(sessaoService.alterar(sessao), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Sessao> delete(@PathVariable("id") Long id){
		sessaoService.deleta(id);
		return new ResponseEntity<Sessao>(HttpStatus.OK);
	}

}
