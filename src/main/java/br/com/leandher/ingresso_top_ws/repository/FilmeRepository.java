package br.com.leandher.ingresso_top_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandher.ingresso_top_ws.model.Filme;

public interface FilmeRepository  extends JpaRepository<Filme, Long>{

}
