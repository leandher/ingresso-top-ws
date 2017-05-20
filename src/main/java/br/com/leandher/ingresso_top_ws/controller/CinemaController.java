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

import br.com.leandher.ingresso_top_ws.model.Cinema;
import br.com.leandher.ingresso_top_ws.service.CinemaService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/cinema")
@Controller
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cinema> getCinema(@PathVariable("id") Long id){
		return new ResponseEntity<Cinema>(cinemaService.getCinema(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cinema>> getListaCinema(){
		return new ResponseEntity<List<Cinema>>(cinemaService.getCinemas(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cinema> save(@RequestBody Cinema cinema){
		return new ResponseEntity<Cinema>(cinemaService.save(cinema), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cinema> edit(@RequestBody Cinema cinema){
		return new ResponseEntity<Cinema>(cinemaService.alterar(cinema), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Cinema> delete(@PathVariable("id") Long id){
		cinemaService.deleta(id);
		return new ResponseEntity<Cinema>(HttpStatus.OK);
	}
}
