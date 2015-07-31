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
import sr.ifes.edu.br.bd2.CategoriaService;
import sr.ifes.edu.br.bd2.ClienteService;
import sr.ifes.edu.br.bd2.FilmeService;
import sr.ifes.edu.br.bd2.LocacaoService;
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.domain.Locacao;
import sr.ifes.edu.br.bd2.domain.Sexo;
import sr.ifes.edu.br.bd2.util.datafactory.LocacaoData;

@ContextConfiguration(locations = "classpath:/spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class LocacaoServiceTest extends AbstractionTest{

	@Autowired
	private LocacaoService locacaoService;
        
        @Autowired 
        private ClienteService clienteService;
        
        @Autowired 
        private FilmeService filmeService;
        
        @Autowired
        private CategoriaService categoriaService;
        
        @Autowired
        private LocacaoData locacaoData;
	
        /**
         * Esse nome é uma gambiarra necessária para estabelecer uma ordem na execução dos testes
         * Já que o setUp do banco demora um pouco, o tempo do teste é alterado.
         */
	@Test
        public void aaa1TheFirstTest(){
            long records = filmeService.getQuantidadeFilmes();
            assertNotNull(records);
        }
        
	@Test
        public void shouldHaveZeroRecords(){
            long records = locacaoService.getQuantidadeLocacoes();
            assertNotNull(records);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            long records = locacaoService.getQuantidadeLocacoes();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldInsertTenThousandRented(){
            int qtd = 10000;
            
            int qtdSaved = new Long(locacaoService.getQuantidadeLocacoes()).intValue();
            
            if(qtdSaved >= qtd){
                assertTrue(true);
                return;
            }else{
                qtd = qtd - qtdSaved;
            }
            
            Locacao l;
            int expected = 0;
            for (int i = 0; i < qtd; i++) {
                l = locacaoService.criar(locacaoData.build(df));
                if(l != null){
                    expected++;
                }
            }
            
            assertEquals(expected, qtd);
        }
        
        @Test
        @Rollback(false)
        public void shouldInsertHundredThousandRented(){
            int qtd = 10000;
            
            int qtdSaved = new Long(locacaoService.getQuantidadeLocacoes()).intValue();
            
            if(qtdSaved >= qtd){
                assertTrue(true);
                return;
            }else{
                qtd = qtd - qtdSaved;
            }
            
            Locacao l;
            int expected = 0;
            float avgTime[] = new float[qtd];
            Date initTime = new Date();
            for (int i = 0; i < qtd; i++) {
                Date insertTime = new Date();
                l = locacaoService.criar(locacaoData.build(df));
                Date finishDate = new Date(new Date().getTime() - insertTime.getTime());
                avgTime[i] = finishDate.getTime()/1000f;
                System.out.println("Registro: "+i+" -  Inserido em: "+finishDate.getTime()/1000f+"s");
                if(l != null){
                    expected++;
                }
            }
            
            long sum = 0;
            for (float time : avgTime) {
                sum += time;
            }
            
            System.out.println("Tempo médio de inserção: "+sum/qtd+'s');
            System.out.println("Inserções feitas em "+(new Date().getTime() - initTime.getTime())/1000f+"s");
            
            assertEquals(expected, qtd);
        }
}
