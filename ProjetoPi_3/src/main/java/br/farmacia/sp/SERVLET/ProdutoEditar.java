/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.SERVLET;

import br.farmacia.sp.DAO.ProdutoDAO;
import br.farmacia.sp.MODEL.Produto;
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
@WebServlet(name = "ProdutoEditar", urlPatterns = {"/ProdutoEditar"})
public class ProdutoEditar extends HttpServlet {

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
        Produto produto = null;
        int codigo = Utils.tryParseInt(request.getParameter("codigo"));
        
        
        if (codigo > 0) {
            produto = ProdutoDAO.retornarProduto(codigo);
        }
        
        request.setAttribute("produto", produto);
        request.setAttribute("teste", "1");
        RequestDispatcher requestDispatcher = getServletContext()
                 .getRequestDispatcher("/ProdutoEditar.jsp");
         requestDispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Produto produto = new Produto(
                Utils.tryParseInt(request.getParameter("codigo")),
                request.getParameter("descricao"),
                Utils.tryParseDouble(request.getParameter("preco")),
                Utils.tryParseLong(request.getParameter("estoque")),
                Utils.tryParseInt(request.getParameter("codigoMarca")),
                Utils.tryParseInt(request.getParameter("codigoCategoria")),
                request.getParameter("codigo")
            );

            if (produto.getCodigo() > 0) {
                ProdutoDAO.alterarProduto(produto);
            } else {
                ProdutoDAO.incluirProduto(produto);
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
