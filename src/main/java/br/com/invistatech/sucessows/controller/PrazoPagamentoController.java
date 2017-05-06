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

import br.com.invistatech.sucessows.model.PrazoPagamento;
import br.com.invistatech.sucessows.service.PrazoPagamentoService;

@Transactional
@CrossOrigin("*")
@RequestMapping("/prazo-pagamento")
@Controller
public class PrazoPagamentoController {

	@Autowired
	private PrazoPagamentoService prazoPagamentoService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrazoPagamento> getPrazoPagamento(@PathVariable("id") Integer id){
		return new ResponseEntity<PrazoPagamento>(prazoPagamentoService.getPrazoPagamento(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PrazoPagamento>> getListaPrazoPagamento(){
		return new ResponseEntity<List<PrazoPagamento>>(prazoPagamentoService.getListaPrazoPagamento(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrazoPagamento> save(@RequestBody PrazoPagamento prazoPagamento){
		return new ResponseEntity<PrazoPagamento>(prazoPagamentoService.save(prazoPagamento), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrazoPagamento> edit(@RequestBody PrazoPagamento prazoPagamento){
		return new ResponseEntity<PrazoPagamento>(prazoPagamentoService.alterar(prazoPagamento), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<PrazoPagamento> delete(@PathVariable("id") Integer id){
		prazoPagamentoService.deleta(id);
		return new ResponseEntity<PrazoPagamento>(HttpStatus.OK);
	}
}
