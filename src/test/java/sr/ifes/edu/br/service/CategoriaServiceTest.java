package sr.ifes.edu.br.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import org.junit.Before;
import sr.ifes.edu.br.bd2.CategoriaService;
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.util.datafactory.CategoriaData;

@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoriaServiceTest extends AbstractionTest{

	@Autowired
	private CategoriaService categoriaService;
        
        @Autowired
        private CategoriaData categoriaData;
	
	@Autowired
	private Neo4jTemplate template;
	
	@Rollback(false)
	@BeforeTransaction
        @Before
	public void cleanUpGraph() {
            Neo4jHelper.cleanDb(template);
	}
	
	@Test
        public void shouldHaveZeroRecords(){
            cleanUpGraph();
            long records = categoriaService.getQuantidadeCategorias();
            assertNotNull(records);
            assertEquals(records, 0);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            Categoria c = new Categoria();
            c.setDescricao("Categoria de Teste");
            c.setPreco(2.3);
            categoriaService.criar(c);
            long records = categoriaService.getQuantidadeCategorias();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldFindLastInsertion(){
            Categoria c = new Categoria();
            c.setDescricao("Categoria de Teste de Insercao");
            c.setPreco(200.0);
            Categoria actual = categoriaService.criar(c);
            assertNotNull(actual);
        }
        
        @Test
        public void shouldInsertTenCategories(){
            
            int qtd = 10;
            List<Categoria> expected = new ArrayList<>();
            
            for (int i = 0; i < qtd; i++) {
                expected.add(categoriaService.criar(categoriaData.criarCategoria(df)));
            }
            
            assertNotNull(expected);
            assertEquals(expected.size(), qtd);
        }
	
}
