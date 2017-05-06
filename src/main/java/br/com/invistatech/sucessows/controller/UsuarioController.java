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

import br.com.invistatech.sucessows.model.Usuario;
import br.com.invistatech.sucessows.service.UsuarioService;

@Transactional
@CrossOrigin("*")	
@RequestMapping("/usuario")
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){
		return new ResponseEntity<Usuario>(usuarioService.getUsuario(id), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getListaUsuario(){
		return new ResponseEntity<List<Usuario>>(usuarioService.getListaUsuario(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}
		
	@RequestMapping(value="/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> edit(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(usuarioService.alterar(usuario), HttpStatus.OK);
	}
		
	@RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> delete(@PathVariable("id") Long id){
		usuarioService.deleta(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
}
