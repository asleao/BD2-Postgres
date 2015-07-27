package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sr.ifes.edu.br.bd2.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByNome(String nome);
}
