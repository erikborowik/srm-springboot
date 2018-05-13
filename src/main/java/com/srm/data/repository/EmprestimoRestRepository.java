package com.srm.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.srm.model.Emprestimo;

@RepositoryRestResource(collectionResourceRel = "emprestimo", path = "emprestimos")
public interface EmprestimoRestRepository extends PagingAndSortingRepository<Emprestimo, Long>{
	
	 List<Emprestimo> findByNome(@Param("name") String name);
	 
	 List<Emprestimo> findByNomeOrderByNome(@Param("name") String name);

}
