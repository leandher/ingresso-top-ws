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

import br.com.leandher.ingresso_top_ws.model.Cliente;
import br.com.leandher.ingresso_top_ws.service.ClienteService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/cliente")
@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id){
		return new ResponseEntity<Cliente>(clienteService.getCliente(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> getListaCliente(){
		return new ResponseEntity<List<Cliente>>(clienteService.getClientes(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.save(cliente), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> edit(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.alterar(cliente), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> delete(@PathVariable("id") Long id){
		clienteService.deleta(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

}
