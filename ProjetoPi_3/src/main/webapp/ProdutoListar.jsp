<%-- 
    Document   : PridutoListar
    Created on : Oct 27, 2020, 9:36:17 PM
    Author     : canejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <main role="main">
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Produtos</h1>
                </div>
                <div class="col">
                    <a href="ProdutoEditar" class="btn btn-outline-secondary"><i class="fas fa-plus"></i> Incluir novo</a>
                </div>
            </div>
            <div class="row">
                <div class="col">
                     <table class="table table-hover">
                        <thead>
                            <th>Descrição</th>
                            <th>Preço</th>
                            <th>Estoque</th>
                            <th>Ações</th>
                        </thead>
                        <tbody>
                            <c:forEach var="produto" items="${produtos}">
                                <tr>
                                    <td>${produto.getDescricao()}</td>
                                    <td>${produto.getPreco()}</td>
                                    <td>${produto.getEstoque()}</td>
                                    <td>
                                        <a href="ProdutoEditar?codigo=${produto.getCodigo()}" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                        <a href="ProdutoDeletar?codigo=${produto.getCodigo()}" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
            </main>
        <%@include file="Error.jsp" %>
    </body>
</html>
