package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.CategoriaNivel2;

public interface CategoriaNivel2Repository extends JpaRepository<CategoriaNivel2, Long> {
	
	@Query("Select catNivel2 from CategoriaNivel2 catNivel2 where catNivel2.categoriaNivel1.id = :nivel1 ")
	public List<CategoriaNivel2> getListaCatNivel2PorN1(@Param("nivel1") Long nivel1);
}
