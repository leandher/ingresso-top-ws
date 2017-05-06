package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.CategoriaNivel3;

public interface CategoriaNivel3Repository extends JpaRepository<CategoriaNivel3, Long> {
	@Query("Select catNivel3 from CategoriaNivel3 catNivel3 where catNivel3.categoriaNivel2.id = :nivel2 ")
	public List<CategoriaNivel3> getListaCatNivel3PorN2(@Param("nivel2") Long nivel2);
}
