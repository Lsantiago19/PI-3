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
        <%@include file="Header.jsp" %>
        <main role="main">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <h1>Relatorio de Vendas</h1>
                    </div>
                </div>

             <div class="form-row">

               <div class="form-group col-md-3">
                        <label for="preco">Nome</label>
                        <input type="text" class="form-control" id="preco" value="${produto.preco}" name="preco">
               </div>

                        <div class="form-group col-md-3">
                          <label for="unidade">Filial</label>
                          <input type="text" class="form-control" id="unidade" value="${produto.unidade}" name="unidade">
                        </div>
                      
               </div>
                        
                <div class="row">
                    <div class="col">
                   
                         <table class="table table-hover">
                            <thead>
                                <th>Nome</th>
                                <th>Data da Venda</th>
                                <th>Valor</th>
                                <th>Filial</th>
                            </thead>
                            <tbody>
                                <c:forEach var="Relatorio" items="${Relatorio}">
                                    <tr>
                                        <td>${Relatorio.getnome()}</td>
                                        <td>${Relatorio.getdataVenda()}</td>
                                        <td>${Relatorio.getprecoTotal()}</td>
                                        <td>${Relatorio.getfilial()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
    </body>

</html>
