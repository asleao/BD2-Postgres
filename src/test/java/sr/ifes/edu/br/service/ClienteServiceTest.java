package sr.ifes.edu.br.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.ClienteService;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Sexo;
import sr.ifes.edu.br.bd2.util.datafactory.ClienteData;

@ContextConfiguration(locations = "classpath:/spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class ClienteServiceTest extends AbstractionTest{

	@Autowired
	private ClienteService clienteService;
        
        @Autowired
        private ClienteData clienteData;
	
	        
        @Test
        @Rollback(false)
        public void shoudInsertTenThousandOfClients(){
            int qtd = 10000;
            int qtdSaved = new Long(clienteService.getQuantidadeClientes()).intValue();
            
            if(qtdSaved >= qtd){
                assertTrue(true);
                return;
            }else{
                qtd = qtd - qtdSaved;
            }
            
            List<Cliente> expected = new ArrayList<>();
            for (int i = 0; i < qtd; i++) {
                expected.add(clienteService.criar(clienteData.build(df)));
            }
            assertNotNull(expected);
            assertEquals(expected.size(), qtd);
        }
        
}
