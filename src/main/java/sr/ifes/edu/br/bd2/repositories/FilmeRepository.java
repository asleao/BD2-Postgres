package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.domain.Filme;

@Repository
@Transactional
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByNome(String nome);
    
    @Query("SELECT f.id from Filme f")
    List<Long> findAllFilmeIds();
}
