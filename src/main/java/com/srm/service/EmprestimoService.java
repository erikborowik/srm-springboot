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
		
		if(emprestimo.getLimiteCredito() == null) {
			throw new IllegalArgumentException("Limite não informado");
		}

		if(emprestimo.getNome() == null) {
			throw new IllegalArgumentException("Nome não informado");
		}

		if(emprestimo.getRisco() == null) {
			throw new IllegalArgumentException("Risco não informado");
		}
		
		calcularJuros(emprestimo);

		return emprestimoRepository.save(emprestimo);
	}

	public void updateEmprestimo(Emprestimo emprestimo) throws NotFoundException {
		calcularJuros(emprestimo);
		if(emprestimo.getId() != null) {
			this.emprestimoRepository.findById(emprestimo.getId())
			.orElseThrow(()->new NotFoundException("não foi localizado o ID:" + emprestimo.getId().toString()));

			emprestimoRepository.save(emprestimo);
		}

	}

	public void deleteEmprestimo(Long id) {
		this.emprestimoRepository.deleteById(id);
	}

	public Emprestimo calcularJuros(Emprestimo emprestimo) {

		if(emprestimo.getLimiteCredito() != null && emprestimo.getRisco() != null) {
			switch (emprestimo.getRisco()) {
			case B:
				emprestimo.setValorPagamento(emprestimo.getLimiteCredito() * 1.10);
				emprestimo.setTaxaJuros(Double.valueOf(10));
				break;
				
			case C:
				emprestimo.setValorPagamento(emprestimo.getLimiteCredito() * 1.20);
				emprestimo.setTaxaJuros(Double.valueOf(20));
				break;

			default:
				emprestimo.setValorPagamento(emprestimo.getLimiteCredito());
				emprestimo.setTaxaJuros(Double.valueOf(0));
				break;
			}
		}else{
			throw new IllegalArgumentException("Dados incompletos");
		}

		return emprestimo;
	}

}
