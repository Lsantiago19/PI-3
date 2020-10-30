/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.DAO;

import br.farmacia.sp.MODEL.RelatorioVendas;
import br.farmacia.sp.SERVLET.ListarRelatorio;
import br.farmacia.sp.bd.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kinha
 */
public class RelatorioVendasDAO {
    
     public static List<RelatorioVendas> consultarRelatorio(String nome) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean filtroNome = nome != null && !nome.isEmpty();

        List<RelatorioVendas> listaRelatorio = new ArrayList<RelatorioVendas>();

        try {
            conexao = ConexaoDB.getConexao();
            String query = "SELECT * FROM relatorio WHERE idVenda = ?";

            if (filtroNome) {
                query += " AND relatorio.nome like ?";
            }

            instrucaoSQL = conexao.prepareStatement(query);
            if (filtroNome) {
                instrucaoSQL.setString(1, nome + "%");
            }

            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                RelatorioVendas p = new RelatorioVendas(
                    rs.getInt("idVenda"),
                    rs.getDate("dataVenda"),
                    rs.getString("nome"),
                    rs.getDouble("precoTotal"),
                    rs.getString("filial")
                                               
                );
                listaRelatorio.add(p);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaRelatorio = null;
        } finally {
        }

        return listaRelatorio;
     }
       
  
}
