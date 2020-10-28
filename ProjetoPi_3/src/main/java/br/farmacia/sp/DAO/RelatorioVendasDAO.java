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
   public static List<RelatorioVendas> getRelatorios(){
    List<RelatorioVendas> listaRelatorios = new ArrayList();
    
       try {
       Connection con = ConexaoDB.getConexao();
       String query = "select * from relatorio";
       PreparedStatement ps = con.prepareStatement(query);
       ResultSet rs = ps.executeQuery();
       
           while (rs.next()) {
               String nome = rs.getString("nome");
               double precototal = rs.getDouble("precototal");
               int idvenda = rs.getInt("idvenda");
               Date datavenda = rs.getDate("datavenda");
               listaRelatorios.add(new RelatorioVendas(idvenda, datavenda, nome, precototal));
               
           }
       }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarRelatorio.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarRelatorio.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
       return null;
   
   }
    
}
