package sr.ifes.edu.br.bd2.repositories;


import sr.ifes.edu.br.bd2.domain.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    @Query(value = "INSERT INTO locacao (cliente_id, filme_id) VALUES (?1, ?2)", nativeQuery=true)
    public void insertNativo(Long idCliente, Long idLocacao);
}
