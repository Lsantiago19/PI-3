/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.MODEL;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author kinha
 */
@Getter
@Setter
public class RelatorioVendas {
    private int idVenda;
    private Date dataVenda;
    private String nomeCli;
    private double precoTotal;
    private String filial;
    
    public RelatorioVendas(int idVenda, Date dataVenda, String nomeCli, double precoTotal, String filial){
    
    this.idVenda = idVenda;
    this.dataVenda = dataVenda;
    this.nomeCli = nomeCli;
    this.precoTotal = precoTotal;
    this.filial = filial;
    
    
    }
  
 
}
