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
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.FilmeService;
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.util.datafactory.FilmeData;

@ContextConfiguration(locations = "classpath:/spring/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class FilmeServiceTest extends AbstractionTest{

	@Autowired
	private FilmeService filmeService;
        
        @Autowired
        private FilmeData filmeData;
	
        /**
         * Esse nome é uma gambiarra necessária para estabelecer uma ordem na execução dos testes
         * Já que o setUp do banco demora um pouco, o tempo do teste é alterado.
         */
	@Test
        public void aaa1TheFirstTest(){
            long records = filmeService.getQuantidadeFilmes();
            assertNotNull(records);
            assertEquals(records, 0);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            Filme f = new Filme();
            f.setDataCompra(new Date());
            f.setNome("Divertidamente");
            f.setPreco(21.0);
            Categoria c = new Categoria("Animação", 8.0);
            f.setCategoria(c);
            filmeService.criar(f);
            long records = filmeService.getQuantidadeFilmes();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldFindLastInsertion(){
            Filme f = new Filme();
            f.setDataCompra(new Date());
            f.setNome("Divertidamente");
            f.setPreco(21.0);
            Categoria c = new Categoria("Animação", 8.0);
            f.setCategoria(c);
            Filme expected = filmeService.criar(f);
            assertNotNull(expected);
        }
        
        @Test
        public void shouldInsertTenThousandFilms(){
            int qtd = 10000;
            List<Filme> expected = new ArrayList<>();
            for (int i = 0; i < qtd; i++) {
                expected.add(filmeService.criar(filmeData.build(df)));
            }
            
            assertNotNull(expected);
            assertEquals(expected.size(), qtd);
        }
	
}
