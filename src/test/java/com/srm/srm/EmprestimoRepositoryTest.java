package com.srm.srm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.srm.data.repository.EmprestimoRepository;
import com.srm.enums.RiscoEnum;
import com.srm.model.Emprestimo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmprestimoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Test
	public void findByName() {
		Emprestimo emprestimo = createEmprestimo();
		Emprestimo item = emprestimoRepository.findByNome("User");
		
		 assertThat(item.getNome())
	      .isEqualTo(emprestimo.getNome());
	}
	
	@Test
	public void findById() {
		Emprestimo emprestimo = createEmprestimo();
		Optional<Emprestimo> optEmprestimo = emprestimoRepository.findById(emprestimo.getId());
		assertThat(optEmprestimo.isPresent()).isTrue();
	}
	
	@Test
	public void delete() {
		Emprestimo emprestimo = createEmprestimo();
		Long id = emprestimo.getId();
		emprestimoRepository.delete(emprestimo);
		Optional<Emprestimo> optEmprestimo = emprestimoRepository.findById(id);
		assertThat(optEmprestimo.isPresent()).isFalse();
	}
	
	
	private Emprestimo createEmprestimo() {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setNome("User");
		emprestimo.setLimiteCredito(Double.valueOf(599.00));
		emprestimo.setRisco(RiscoEnum.A);
		
		emprestimo = entityManager.persist(emprestimo);
		entityManager.flush();
		
		return emprestimo;
	}

}
