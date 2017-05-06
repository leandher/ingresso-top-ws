package br.com.invistatech.sucessows.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.invistatech.sucessows.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	

}
