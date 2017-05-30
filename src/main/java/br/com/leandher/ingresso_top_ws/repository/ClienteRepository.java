package br.com.leandher.ingresso_top_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.leandher.ingresso_top_ws.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("select c from Cliente c where c.email like :email and c.senha = :senha")
	public Cliente login(@Param("email") String email, @Param("senha") String senha);
}
