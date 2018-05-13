package com.srm.service;

import com.srm.model.Emprestimo;

import javassist.NotFoundException;

public interface EmprestimoService {

	Emprestimo create(Emprestimo emprestimo);

	void updateEmprestimo(Emprestimo emprestimo) throws NotFoundException;

	void deleteEmprestimo(Long id);

	Emprestimo calcularJuros(Emprestimo emprestimo);
	
	Emprestimo findByNome(String nome);

}