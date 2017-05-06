package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.QuestionarioFornecedor;

public interface QuestionarioFornecedorRepository extends JpaRepository<QuestionarioFornecedor, Long>{
	
	@Query("select f.questionarios FROM Fornecedor f WHERE f.id = :idFornecedor")
	public List<QuestionarioFornecedor> getQuestionarios(@Param("idFornecedor") Long id);
}
