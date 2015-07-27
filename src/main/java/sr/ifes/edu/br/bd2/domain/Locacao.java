/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
public class Locacao extends Model{
    
    
    private static final long serialVersionUID = 1L;   
    
    @Column
    private Date dataLocacao;
    @Column
    private Date dataDevolucao;
    @Column
    private Double multa;
    
    @OneToOne
    private Filme filme;
    
    @OneToOne
    private Cliente cliente;
}
