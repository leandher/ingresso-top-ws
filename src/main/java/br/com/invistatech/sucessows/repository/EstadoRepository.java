package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.Cidade;
import br.com.invistatech.sucessows.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	@Query("SELECT cidade FROM Cidade cidade WHERE cidade.estado.id = :estado")
	public List<Cidade> getCidades(@Param("estado") Long estado);
}
