/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.DAO;

import br.farmacia.sp.MODEL.Vendas;
import br.farmacia.sp.bd.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jardel
 */
public class VendasDAO {
    
    public static List<Vendas> GetVendas() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        List<Vendas> listaVendas = new ArrayList<Vendas>();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                Vendas p = new Vendas(
                    rs.getString("produto"),
                    rs.getString("categoria"),
                    rs.getInt("quantidade"),
                    rs.getString("unidade"),
                    rs.getString("cpf"),
                    rs.getString("nomeVendedor"),
                    rs.getDouble("desconto")
                );
                listaVendas.add(p);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaVendas = null;
        } finally {
        }

        return listaVendas;
     }
}
