package com.srm.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srm.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
