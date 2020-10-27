/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.DAO;

import br.farmacia.sp.MODEL.Produto;
import br.farmacia.sp.bd.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author canejo
 */
public class ProdutoDAO {
     public static ArrayList<Produto> consultarProdutos(String nome) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean filtroNome = nome != null && !nome.isEmpty();

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        try {
            conexao = ConexaoDB.getConexao();
            String query = "SELECT pro.*, cat.nome nome_categoria FROM produto pro left join categoria cat on pro.categoria = cat.id WHERE 1 = 1";

            if (filtroNome) {
                query += " AND pro.nome like ?";
            }

            instrucaoSQL = conexao.prepareStatement(query);
            if (filtroNome) {
                instrucaoSQL.setString(1, nome + "%");
            }

            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                Produto p = new Produto();
                p.setCodigo(rs.getInt("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setUnidade(rs.getString("unidade"));
                p.setPreco(rs.getDouble("preco"));
                p.setCodigoCategoria(rs.getInt("codigocategoria"));
                p.setEstoque(rs.getInt("estoque"));
                //p.setNomeCategoria(rs.getString("nome_categoria"));

                listaProdutos.add(p);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        } finally {
        }

        return listaProdutos;
     }
}
