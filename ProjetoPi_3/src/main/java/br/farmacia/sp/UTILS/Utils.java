/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.farmacia.sp.UTILS;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jardel
 */
public class Utils {
    
    public static int tryParseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
    
    public static int tryParseInt(String value) {
        return tryParseInt(value, 0);
    }
    
    public static double tryParseDouble(String value, double defaultVal) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return defaultVal;
        }
    }
    
    public static double tryParseDouble(String value) {
        return tryParseDouble(value, 0);
    }
    
    public static long tryParseLong(String value, long defaultVal) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            return defaultVal;
        }
    }
    
    public static long tryParseLong(String value) {
        return tryParseLong(value, 0);
    }
    
    public static void mostrarTelaErro(Exception ex, 
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msgErro = ex.getMessage();
        request.setAttribute("msgErro", msgErro);
        RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/erro.jsp");
        requestDispatcher.forward(request, response);
    }
    
    public static void mostrarTelaSucesso(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("sucesso.jsp");
    }
}
