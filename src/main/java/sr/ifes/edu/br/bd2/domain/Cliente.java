/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;


import java.util.Date;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author breno
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cliente extends Model{
    
    
    private static final long serialVersionUID = 1L;   
    
    
    @Column
    private String nome;
    @Column    
    private Date dataNascimento;
    @Column
    private Sexo sexo;
    
    @Override
    public String toString() {
        return "Cliente{" + "id:" + this.getId() + ", nome:" + nome + ", dataNascimento:" + dataNascimento + ", sexo:" + sexo + '}';
    }
}
