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
import java.util.List;

/**
 *
 * @author canejo
 */
public class ProdutoDAO {
     public static List<Produto> consultarProdutos(String nome) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean filtroNome = nome != null && !nome.isEmpty();

        List<Produto> listaProdutos = new ArrayList<Produto>();

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
                Produto p = new Produto(
                    rs.getInt("codigo"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque"),
                    rs.getInt("codigomarca"),
                    rs.getInt("codigocategoria"),
                    rs.getString("unidade")
                );
                listaProdutos.add(p);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        } finally {
        }

        return listaProdutos;
     }

    public static void alterarProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void incluirProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Produto retornarProduto(int tryParseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void deletarProduto(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
