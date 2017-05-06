package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.ReferenciaComercial;

public interface ReferenciaComercialRepository extends JpaRepository<ReferenciaComercial, Long>{
	
	@Query("SELECT f.referencias FROM Fornecedor f WHERE f.id = :idFornecedor")
	public List<ReferenciaComercial> getReferencias(@Param("idFornecedor") Long id);
}
