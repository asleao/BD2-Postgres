package sr.ifes.edu.br.bd2.repositories;


import sr.ifes.edu.br.bd2.domain.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {}
