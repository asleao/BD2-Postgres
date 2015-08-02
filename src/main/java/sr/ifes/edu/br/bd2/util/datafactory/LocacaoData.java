/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import java.util.Date;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sr.ifes.edu.br.bd2.ClienteService;
import sr.ifes.edu.br.bd2.FilmeService;
import sr.ifes.edu.br.bd2.domain.Locacao;

/**
 *
 * @author dred
 */
@Service
public class LocacaoData {
       
    @Autowired
    private ClienteData clienteData;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private FilmeService filmeService;
    
    @Autowired
    private FilmeData filmeData;
    
    public Locacao build(DataFactory df){
        
        Locacao locacao = new Locacao();
        
        locacao.setDataLocacao(df.getDateBetween(df.getDate(1960, 1, 1),
                                              df.getDate(2015, 8, 1)));
        Date dataDevolucao = new Date();
        int diasAmais = df.getNumberBetween(5, 15);
        dataDevolucao.setDate(locacao.getDataLocacao().getDate()+ diasAmais);
        locacao.setDataDevolucao(dataDevolucao);
        
        List<Long> clientes = clienteService.obterListaDeIds();
        locacao.setCliente(clienteService.obter(df.getItem(clientes)));
        locacao.setFilme(filmeService.obter(df.getItem(filmeService.obterListaDeIds())));
        
        if(diasAmais > 5){
            locacao.setMulta(new Double(((diasAmais-5)*2)));
        }
        
        return locacao;
    }
    
    public Locacao build(DataFactory df, Long clienteId, Long filmeId){
        
        Locacao locacao = new Locacao();
        
        locacao.setDataLocacao(df.getDateBetween(df.getDate(1960, 1, 1),
                                              df.getDate(2015, 8, 1)));
        Date dataDevolucao = new Date();
        int diasAmais = df.getNumberBetween(5, 15);
        dataDevolucao.setDate(locacao.getDataLocacao().getDate()+ diasAmais);
        locacao.setDataDevolucao(dataDevolucao);
        
        locacao.setCliente(clienteService.obter(clienteId));
        locacao.setFilme(filmeService.obter(filmeId));
        
        if(diasAmais > 5){
            locacao.setMulta(new Double(((diasAmais-5)*2)));
        }
        
        return locacao;
    }
    
}
