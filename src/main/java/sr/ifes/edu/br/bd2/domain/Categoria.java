/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author breno
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Categoria extends Model{
    
    
    private static final long serialVersionUID = 1L;   

    @Column
    private String descricao;
    
    @Column
    private Double preco;

    @Override
    public String toString() {
        return "Categoria{" + "id:" + this.getId() + ", descricao:" + descricao + ", preco:" + preco + '}';
    }
}
