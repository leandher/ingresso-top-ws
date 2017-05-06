package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	@Query("SELECT f.contatos FROM Fornecedor f WHERE f.id = :idFornecedor")
	public List<Contato> getContatosByFornecedor(@Param("idFornecedor") Long id);
}
