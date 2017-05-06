package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.Usuario;
import br.com.invistatech.sucessows.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getListaUsuario(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(Long id){
		return usuarioRepository.findOne(id);
	}
	
	public Usuario save(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	public Usuario alterar(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	public void deleta(Long id){
		 usuarioRepository.delete(id);
	}
}
