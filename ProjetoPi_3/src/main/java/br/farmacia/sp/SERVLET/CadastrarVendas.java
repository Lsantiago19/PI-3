/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.SERVLET;

import br.farmacia.sp.DAO.VendasDAO;
import br.farmacia.sp.MODEL.Vendas;
import br.farmacia.sp.UTILS.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jardel
 */
public class CadastrarVendas extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String produto = request.getParameter("produto");
        String quantidadeStr = request.getParameter("quantidade");
        String unidade = request.getParameter("unidade");
        String categoria = request.getParameter("categoria");
        String nomeVendedor = request.getParameter("nomeVendedor");
        String cpf = request.getParameter("cpf");
        String descontoStr = request.getParameter("desconto");
        String totalVendaStr = request.getParameter("totalVenda");
        int quantidade = Integer.parseInt(quantidadeStr);
        double desconto = Double.parseDouble(descontoStr);
        double totalVenda = Double.parseDouble(totalVendaStr);
        
        
        Vendas vendas = new Vendas(produto, quantidade, unidade, categoria, nomeVendedor, cpf, desconto, totalVenda);
        try {
            VendasDAO.addVenda(vendas);
            response.sendRedirect("Sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex)  {
            Logger.getLogger(CadastrarVendas.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
    
}
