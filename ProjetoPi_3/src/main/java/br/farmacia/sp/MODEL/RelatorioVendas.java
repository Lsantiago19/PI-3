/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.MODEL;

import java.util.Date;

/**
 *
 * @author kinha
 */

public class RelatorioVendas {
    private int idVenda;
    private Date dataVenda;
    private String nomeCli;
    private double precoTotal;
    
    public RelatorioVendas(int idVenda, Date dataVenda, String nomeCli, double precoTotal){
    
    this.idVenda = idVenda;
    this.dataVenda = dataVenda;
    this.nomeCli = nomeCli;
    this.precoTotal = precoTotal;
    
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    
        @Override
    public String toString() {
        return String.format("idVenda %s <br/> Data da Venda %s <br/> Nome %s <br/> PreçoTotal %d" , 
               this.getIdVenda(), this.getDataVenda(), this.getNomeCli(), this.getPrecoTotal());
    }
}