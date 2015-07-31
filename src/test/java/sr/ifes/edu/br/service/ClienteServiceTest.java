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
	
	        
        /**
         * Esse nome é uma gambiarra necessária para estabelecer uma ordem na execução dos testes
         * Já que o setUp do banco demora um pouco, o tempo do teste é alterado.
         */
	@Test
        public void aaa1TheFirstTest(){
            long records = clienteService.getQuantidadeClientes();
            assertNotNull(records);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            Cliente c = new Cliente();
            c.setDataNascimento(new Date());
            c.setNome("Moisés Omena");
            c.setSexo(Sexo.MASCULINO);
            clienteService.criar(c);
            long records = clienteService.getQuantidadeClientes();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldFindLastInsertion(){
            Cliente c = new Cliente();
            c.setDataNascimento(new Date());
            c.setNome("Moisés Omena");
            c.setSexo(Sexo.MASCULINO);
            Cliente expected = clienteService.criar(c);
            assertNotNull(expected);
        }
        
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
        
        @Test
        public void shoudHaveALongListOfLongs(){
            List<Long> ids = clienteService.obterListaDeIds();
            assertTrue(ids.size() > 0);
        }
	
}
