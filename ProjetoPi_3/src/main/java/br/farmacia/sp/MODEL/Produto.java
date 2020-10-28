/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.MODEL;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author canejo
 */
@Getter
@Setter
public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private long estoque;
    private int codigoMarca;
    private int codigoCategoria;
    private String unidade;
   
    public Produto(
        int codigo,
        String descricao,
        double preco,
        long estoque,
        int codigoMarca,
        int codigoCategoria,
        String unidade
    ) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.codigoMarca = codigoMarca;
        this.codigoCategoria = codigoCategoria;
        this.unidade = unidade;
    }
}
