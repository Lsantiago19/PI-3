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
    public static List<RelatorioVendas> getRelatorio() {
        List<RelatorioVendas> listaClientes = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                Date dataVenda = rs.getDate("dataVenda");
                String nomeCli = rs.getString("nome");
                Double precoTotal = rs.getDouble("precoTotal");
                listaClientes.add(new RelatorioVendas(idVenda,dataVenda ,nomeCli,precoTotal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarRelatorio.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioVendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return listaClientes;
    }
}
