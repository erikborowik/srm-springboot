package com.srm.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.srm.enums.RiscoEnum;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)    
	private Long id;

	private String nome;

	private Double limiteCredito;
	
	private Double valorPagamento;

	@Enumerated(EnumType.ORDINAL)
	private RiscoEnum risco;
	
	private Double taxaJuros;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public RiscoEnum getRisco() {
		return risco;
	}

	public void setRisco(RiscoEnum risco) {
		this.risco = risco;
	}

	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	

}
