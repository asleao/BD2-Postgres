package sr.ifes.edu.br.bd2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.domain.Cliente;

import sr.ifes.edu.br.bd2.repositories.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	public long getQuantidadeClientes(){
            return clienteRepository.count();
        }
        
        public Cliente criar(Cliente cliente){
            return clienteRepository.save(cliente);
        }
        
        public Cliente obter(int id){
            return clienteRepository.findOne(new Long(id));
        }
        
        public List<Long> obterListaDeIds(){
            return clienteRepository.findAllClientId();
        }
}
