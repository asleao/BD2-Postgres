package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sr.ifes.edu.br.bd2.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
}
