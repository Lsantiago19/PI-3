/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.RelatorioVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Lucas Santiago
 */
public class RelatorioVendasDAO {
    
    public static ArrayList<RelatorioVendas> consultarVendas(Date dataInicio, Date dataFim) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<RelatorioVendas> vendas = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT ped.*, cli.nome FROM pedido ped left join cliente cli on ped.cliente = cli.id WHERE ped.inclusao BETWEEN ? AND ? order by ped.inclusao desc, ped.id desc");
            instrucaoSQL.setDate(1, new java.sql.Date(dataInicio.getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(dataFim.getTime()));
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                RelatorioVendas venda = new RelatorioVendas();

                venda.setIdVenda(rs.getInt("id"));
                venda.setDataVenda(rs.getDate("inclusao"));
                venda.setNomeCli(rs.getString("nome"));
                venda.setPrecoTotal(rs.getDouble("total"));

                vendas.add(venda);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            vendas = null;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        return vendas;
    }
}