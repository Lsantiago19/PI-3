/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.SERVLET;

import br.farmacia.sp.DAO.ProdutoDAO;
import br.farmacia.sp.UTILS.Utils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author canejo
 */
@WebServlet(name = "ProdutoDeletar", urlPatterns = {"/ProdutoDeletar"})
public class ProdutoDeletar extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int codigo = Utils.tryParseInt(request.getParameter("codigo"));
            if (codigo > 0) {
                ProdutoDAO.deletarProduto(codigo);
            }
         } catch (Exception  ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/ProdutoListar.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
