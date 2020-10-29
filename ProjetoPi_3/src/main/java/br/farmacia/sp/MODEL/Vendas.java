/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.MODEL;

/**
 *
 * @author Jardel
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vendas {
    
    private String produto;
    private String categoria;
    private int quantidade;
    private String unidade;
    private String cpf;
    private String nomeVendedor;
    private double desconto;
    
    public Vendas(
    String produto,
            String categoria,
            int quantidade,
            String unidade,
            String cpf,
            String nomeVendedor,
            double desconto
    ){
        this.produto = produto;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.cpf = cpf;
        this.nomeVendedor = nomeVendedor;
        this.desconto = desconto;
    }
   
}

