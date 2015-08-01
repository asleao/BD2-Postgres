package sr.ifes.edu.br.service;

import java.util.ArrayList;
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
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.util.datafactory.CategoriaData;

@ContextConfiguration(locations = "classpath:/spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional()
public class CategoriaServiceTest extends AbstractionTest{

	@Autowired
	private CategoriaService categoriaService;
        
        @Autowired
        private CategoriaData categoriaData;
	
        @Test
        @Rollback(false)
        public void shouldInsertTenCategories(){
            
            int qtd = 10;
            int qtdSaved = new Long(categoriaService.getQuantidadeCategorias()).intValue();
            
            if(qtdSaved >= qtd){
                assertTrue(true);
                return;
            }else{
                qtd = qtd - qtdSaved;
            }
            
            List<Categoria> expected = new ArrayList<>();
            
            for (int i = 0; i < qtd; i++) {
                expected.add(categoriaService.criar(categoriaData.criarCategoria(df)));
            }
            
            assertNotNull(expected);
            assertEquals(expected.size(), qtd);
        }
	
}
