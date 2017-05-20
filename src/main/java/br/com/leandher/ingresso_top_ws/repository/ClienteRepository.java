package br.com.leandher.ingresso_top_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandher.ingresso_top_ws.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
