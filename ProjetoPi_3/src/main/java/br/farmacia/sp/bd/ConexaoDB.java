/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tscarton
 */
public class ConexaoDB {
    
    // Bloco executado uma única vez quando o servidor é inicializado
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }
    
    public static Connection getConexao() 
            throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/vendas?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
    
}
