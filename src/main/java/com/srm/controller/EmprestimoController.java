package com.srm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.data.repository.EmprestimoRepository;
import com.srm.data.repository.EmprestimoRestRepository;
import com.srm.model.Emprestimo;
import com.srm.service.EmprestimoService;

import javassist.NotFoundException;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {
	
	private final EmprestimoRepository emprestimoRepository;
	
	private final EmprestimoRestRepository emprestimoRestRepository;
	
	private final EmprestimoService emprestimoService;
	
	@Autowired
	public EmprestimoController(EmprestimoRepository emprestimoRepository, EmprestimoRestRepository emprestimoRestRepository,
			 EmprestimoService emprestimoService) {
		this.emprestimoRepository = emprestimoRepository;
		this.emprestimoRestRepository = emprestimoRestRepository;
		this.emprestimoService = emprestimoService;
	}

	
	@GetMapping("/{id}")
	public Emprestimo getEmprestimoById(@PathVariable Long id) throws NotFoundException{
		return this.emprestimoRepository.findById(id)
				.orElseThrow(()->new NotFoundException("não foi localizado o ID:" + id.toString()));
	}
	
	@PostMapping
	public ResponseEntity<?> addEmprestimo(@RequestBody Emprestimo emprestimo){
		Emprestimo newEmprestimo = emprestimoService.create(emprestimo);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEmprestimo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) throws NotFoundException{
		
		emprestimo.setId(id);
		emprestimoService.updateEmprestimo(emprestimo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("search/findByNome/{nome}")
	public Collection<Emprestimo> getByNome(@PathVariable String nome){
		
		return emprestimoRestRepository.findByNome(nome);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id){
		emprestimoService.deleteEmprestimo(id);
		return ResponseEntity.ok().build();
	}
	
}
