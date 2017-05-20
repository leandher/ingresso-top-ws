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

import br.com.leandher.ingresso_top_ws.model.Compra;
import br.com.leandher.ingresso_top_ws.service.CompraService;

@Transactional
@CrossOrigin("*")
@RequestMapping("/compra")
@Controller
public class CompraController {
	
	@Autowired
	private CompraService compraService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compra> getCompra(@PathVariable("id") Long id) {
		return new ResponseEntity<Compra>(compraService.getCompra(id), HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Compra>> getListaCompra() {
		return new ResponseEntity<List<Compra>>(compraService.getCompras(), HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compra> save(@RequestBody Compra compra) {
		return new ResponseEntity<Compra>(compraService.save(compra), HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compra> edit(@RequestBody Compra compra) {
		return new ResponseEntity<Compra>(compraService.alterar(compra), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Compra> delete(@PathVariable("id") Long id) {
		compraService.deleta(id);
		return new ResponseEntity<Compra>(HttpStatus.OK);
	}

}
