package com.srm.srm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.srm.data.repository.EmprestimoRepository;
import com.srm.enums.RiscoEnum;
import com.srm.model.Emprestimo;
import com.srm.service.EmprestimoService;
import com.srm.service.EmprestimoServiceImpl;

@RunWith(SpringRunner.class)
public class EmprestimoServiceTest {
	
	
    @TestConfiguration
    static class EmprestimoServiceTestContextConfiguration {
  
        @Bean
        public EmprestimoService emprestimoService() {
            return new EmprestimoServiceImpl();
        }
    }
    
    @Autowired
    private EmprestimoService emprestimoService;
    
    @MockBean
    private EmprestimoRepository emprestimoRepository;
    
    @Before
    public void init() {
    	Emprestimo emprestimo = new Emprestimo();
		emprestimo.setNome("User");
		emprestimo.setLimiteCredito(Double.valueOf(599.00));
		emprestimo.setRisco(RiscoEnum.A);
		emprestimo.setId(Long.valueOf(1l));
		
		Mockito.when(emprestimoRepository.findByNome(emprestimo.getNome()))
	      .thenReturn(emprestimo);
		
    }
    
    @Test
    public void findByNome() {
    	String nome = "User";
    	Emprestimo item = emprestimoService.findByNome(nome);
    	assertThat(item.getNome()).isEqualTo(nome);
    }
    
}
