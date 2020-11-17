/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.DAO;

import br.farmacia.sp.MODEL.Cliente;
import br.farmacia.sp.SERVLET.ServletBD;
import br.farmacia.sp.bd.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lucas Santiago
 */
public class clienteDAO {

    public static List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Long cpf = rs.getLong("cpf");
                listaClientes.add(new Cliente(nome, email, cpf));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.getConexao();
        String query = "insert into cliente (nome, email, cpf) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setLong(3, cliente.getCpf());
        ps.execute();
    }
    
    public static void updateCliente( Cliente cliente) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoDB.getConexao();
        String query = "update cliente set nome=?,email=? where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setLong(3, cliente.getCpf());
        ps.execute();
    }
    
    public static void deleteCliente( Long cpf) throws SQLException, ClassNotFoundException{
        Connection con = ConexaoDB.getConexao();
        String query = "delete from cliente where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, cpf);
        ps.execute();
    }

    public static Cliente getCliente(Long cpf) {
        Cliente cliente = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                cliente = new Cliente(nome, email, cpf);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}
