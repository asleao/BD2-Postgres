package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.domain.Categoria;

@Repository
@Transactional
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByDescricao(String descricao);
}
