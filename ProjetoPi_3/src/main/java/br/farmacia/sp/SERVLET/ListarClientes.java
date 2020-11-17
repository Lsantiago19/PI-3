/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.SERVLET;


import br.farmacia.sp.DAO.clienteDAO;
import br.farmacia.sp.MODEL.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Lucas Santiago
 */
public class ListarClientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> listaClientes = clienteDAO.getClientes();
        request.setAttribute("listaClientes", listaClientes);
        
         RequestDispatcher requestDispatcher = getServletContext()
                 .getRequestDispatcher("/listaClientes.jsp");
         requestDispatcher.forward(request, response);
    }

}
