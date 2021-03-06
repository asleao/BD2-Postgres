/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;

import java.util.Date;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Index;

/**
 *
 * @author breno
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Filme extends Model{
    
    private static final long serialVersionUID = 1L;    
    
    @Index(name = "index_id_filme")
    @Column(insertable = false, updatable = false)
    private Long id;
    
    @Column
    private String nome;
    
    @Column
    private Date dataCompra;
    
    @Column
    private Double preco;
    
    @OneToOne
    private Categoria categoria;
    
    @Column
    private Long paisOrigem;

    @Override
    public String toString() {
        return "Filme{" + "id:" + this.getId() + ", nome:" + nome + ", dataCompra:" + dataCompra + ", preco:" + preco + ", categoria:" + categoria + '}';
    }
    
}
