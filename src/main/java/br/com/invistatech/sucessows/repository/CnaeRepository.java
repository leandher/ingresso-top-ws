package br.com.invistatech.sucessows.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.invistatech.sucessows.model.Cnae;

public interface CnaeRepository extends JpaRepository<Cnae, Integer> {

//	Page<Cnae> getCnaePaginado(Pageable pageable);
}
