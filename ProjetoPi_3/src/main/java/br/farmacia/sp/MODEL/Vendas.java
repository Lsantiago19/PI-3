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
    private double totalVenda;
    
    public Vendas(
    String produto,
            String categoria,
            int quantidade,
            String unidade,
            String cpf,
            String nomeVendedor,
            double desconto,
            double totalVenda
    ){
        this.produto = produto;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.cpf = cpf;
        this.nomeVendedor = nomeVendedor;
        this.desconto = desconto;
        this.totalVenda = totalVenda;
    }

    public Vendas(String produto, int quantidade, String unidade, String categoria, String nomeVendedor, String cpf, double desconto, double totalVenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return String.format("Produto %s <br/> Quantidade %s <br/> Unidade %s <br/> Categoria %s <br/> NomeVendedor %s <br/> Cpf %s <br/> Desconto %s <br/> TotalVendas %d" , 
                this.getProduto(), this.getQuantidade(), this.getUnidade(), this.getCategoria(), this.getNomeVendedor(), this.getCpf(), this.getDesconto(), this.getTotalVenda());
    }
   
}

