<%-- 
    Document   : listaVendas
    Created on : 28/10/2020, 22:05:25
    Author     : Jardel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de vendas</title>
    </head>
    <body>
        <h1>Lista de vendas</h1>
        <table class="table">
            <thead>
                <th>Produto</th>
                <th>Categoria</th>
                <th>Quantidade</th>
                <th>Unidade</th>
                <th>CPF</th>
                <th>Nome do vendedor</th>
                <th>Desconto</th>
            </thead>
            <tbody> 
                <c:forEach var="venda" items="${listaVendas}">
                    <tr>
                        <td>${venda.getProduto}</td>
                        <td>${venda.getCategoria}</td>
                        <td>${venda.getQuantidade}</td>
                        <td>${venda.getUnidade}</td>
                        <td>${venda.getCpf}</td>
                        <td>${venda.getNomeVendedor}</td>
                        <td>${venda.getDesconto}</td>
                    </tr>
                </c:forEach>
                
            </tbody>
            
        </table>
    </body>
</html>
