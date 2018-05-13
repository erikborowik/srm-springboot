package com.srm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.data.repository.EmprestimoRepository;
import com.srm.model.Emprestimo;

import javassist.NotFoundException;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;


	public Emprestimo create(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public void updateEmprestimo(Emprestimo emprestimo) throws NotFoundException {

		if(emprestimo.getId() != null) {
			this.emprestimoRepository.findById(emprestimo.getId())
			.orElseThrow(()->new NotFoundException("não foi localizado o ID:" + emprestimo.getId().toString()));

			emprestimoRepository.save(emprestimo);
		}

	}

	public void deleteEmprestimo(Long id) {
		this.emprestimoRepository.deleteById(id);
	}

}
