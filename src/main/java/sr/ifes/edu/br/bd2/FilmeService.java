package sr.ifes.edu.br.bd2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.repositories.FilmeRepository;

@Service
@Transactional
public class FilmeService {
	
	@Autowired
	public FilmeRepository filmeRepository;
	
	public long getQuantidadeFilmes(){
            return filmeRepository.count();
        }
        
        public Filme criar(Filme filme){
            return filmeRepository.save(filme);
        }
        
        public Filme obter(Long id){
            return filmeRepository.findOne(id);
        }
        
        public List<Long> obterListaDeIds(){
            return filmeRepository.findAllFilmeIds();
        }
}
