/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.DAO;

import br.farmacia.sp.MODEL.Usuario;
import br.farmacia.sp.bd.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author canejo
 */
public class UsuarioDAO {
    public static Usuario retornarUsuario(String apelido) {
        Usuario usuario = new Usuario();
         try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from usuario where apelido = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, apelido);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setCodigoCargo(rs.getInt("codigoCargo"));
                break;
            }
        } catch (Exception  ex) {
           System.out.println(ex.getMessage());
           usuario = null;
        }
        return usuario;
    }
}
