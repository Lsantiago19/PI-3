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
import java.sql.SQLException;
import java.sql.Statement;
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
            String query = "SELECT pro.* FROM produto pro WHERE 1 = 1";

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

    public static boolean alterarProduto(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.getConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, unidade = ?, preco = ?, categoria = ?, estoque = ? WHERE id = ?");
            instrucaoSQL.setString(1, produto.getDescricao());
            instrucaoSQL.setString(2, produto.getUnidade());
            instrucaoSQL.setDouble(3, produto.getPreco());
            instrucaoSQL.setInt(5, produto.getCodigoCategoria());
            instrucaoSQL.setLong(6, produto.getEstoque());
            instrucaoSQL.setInt(7, produto.getCodigo());
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
        }
        return retorno;
    }

    public static Produto incluirProduto(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.getConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, unidade, preco, categoria, estoque) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, produto.getDescricao());
            instrucaoSQL.setString(2, produto.getUnidade());
            instrucaoSQL.setDouble(3, produto.getPreco());
            instrucaoSQL.setInt(4, produto.getCodigoCategoria());
            instrucaoSQL.setLong(5, produto.getEstoque());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    produto.setCodigo(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID do produto.");
                }
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
        }
        return produto;
    }

    public static Produto retornarProduto(int codigo) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Produto produto = null;

        try {
            conexao = ConexaoDB.getConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT pro.* FROM produto pro WHERE pro.id = ?");
            instrucaoSQL.setInt(1, codigo);
            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                produto = new Produto(
                    rs.getInt("codigo"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque"),
                    rs.getInt("codigomarca"),
                    rs.getInt("codigocategoria"),
                    rs.getString("unidade")
                );
                break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            produto = null;
        } finally {
        }

        return produto;
    }

    public static boolean deletarProduto(int codigo) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.getConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE id = ?");
            instrucaoSQL.setInt(1, codigo);
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
        }
        return retorno;
    }
}
