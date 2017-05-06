package br.com.invistatech.sucessows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.invistatech.sucessows.model.CategoriaNivel3;
import br.com.invistatech.sucessows.model.Estado;
import br.com.invistatech.sucessows.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	
	@Query("SELECT f FROM Fornecedor f WHERE f.cpfCnpj LIKE :cpfCnpj")
	public Fornecedor getFornecedorByCpfCnpj(@Param("cpfCnpj") String cpfCnpj); 
	
	@Query("SELECT f FROM Fornecedor f WHERE f.cpfCnpj LIKE :cpfCnpj AND f.senha LIKE :senha")
	public Fornecedor login(@Param("cpfCnpj") String cpfCnpj, @Param("senha") String senha); 
	
	@Query("SELECT f.estadoAtuacao FROM Fornecedor f WHERE f.id = :id")
	public List<Estado> getEstadosAtuacao(@Param("id") Long id);
	
	@Query("SELECT f, f.categoriasNivel3 FROM Fornecedor f left join fetch f.categoriasNivel3 cn3 left join cn3.categoriaNivel2 cn2 left join cn2.categoriaNivel1 cn1")
	public List<Fornecedor> all();
	
	@Query("SELECT f.categoriasNivel3 FROM Fornecedor f left join f.categoriasNivel3 cn3 left join cn3.categoriaNivel2 cn2 left join cn2.categoriaNivel1 cn1 WHERE f.id = :id")
	public List<CategoriaNivel3> getCategorias(@Param("id") Long id);
	
}
