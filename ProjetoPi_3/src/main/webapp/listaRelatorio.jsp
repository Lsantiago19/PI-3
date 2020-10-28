<%-- 
    Document   : listaRelatorio
    Created on : 26/10/2020, 22:28:05
    Author     : kinha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio de Vendas</title>
    </head>
    <body>
        <h1>Relatorio de Vendas</h1>
        
         <thead>
                <th>Nome</th>
                <th>Data da Venda</th>
                <th>Valor Total</th>
            </thead>
            <tbody> 
                
                <c:forEach var="relatorio" items="${listaRelatorio}">
                    <tr>
                        <td>${relatorio.dataEntrega}</td>
                        <td>${relatorio.nomeCli}</td>
                        <td>${relatorio.valorTotal}</td>
                        <td><a href="AlterarCliente?cpf=${cliente.cpf}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf}, '${cliente.nome}')">Excluir</button></td>
                    </tr>
                </c:forEach>
                    
            </tbody>
            
        </table>
    </body>
</html>
