<%-- 
    Document   : listaClientes
    Created on : 29/10/2020, 12:38:39
    Author     : Lucas Santiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body class="container">
        <h1>Lista de Clientes</h1>
        <table class="table">
            <thead>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
            </thead>
            <tbody> 
                <c:forEach var="cliente" items="${listaClientes}">
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td><a href="AlterarCliente?cpf=${cliente.cpf}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf}, '${cliente.nome}')">Excluir</button></td>
                    </tr>
                </c:forEach>
                
            </tbody>
            
        </table>
         <a href="Header.jsp">Voltar</a><br>
         <a href="cadastrarCliente.jsp">Cadastrar</a>
</body>
</html>
