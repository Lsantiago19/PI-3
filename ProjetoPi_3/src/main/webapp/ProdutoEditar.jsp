<%-- 
    Document   : ProdutoEditar
    Created on : Oct 27, 2020, 9:57:54 PM
    Author     : canejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <main role="main">
            <div class="container">
                <h1>Produto e Serviços</h1>

                <form action="ProdutoEditar" method="POST">
                    <input type="hidden" value="${produto.codigo}" id="codigo" name="codigo">
                     <div class="form-group">
                        <label for="descricao">Descrição</label>
                        <input type="text" class="form-control" id="descricao" value="${produto.descricao}" name="descricao">
                      </div>
                    <div class="form-row">
                      <div class="form-group col-md-3">
                        <label for="preco">Preço</label>
                        <input type="number" class="form-control" id="preco" value="${produto.preco}" name="preco">
                      </div>
                        <div class="form-group col-md-3">
                          <label for="unidade">Unidade</label>
                          <input type="text" class="form-control" id="unidade" value="${produto.unidade}" name="unidade">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                          <label for="estoque">Estoque</label>
                          <input type="number" class="form-control" id="estoque" value="${produto.estoque}" name="estoque">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary col-2">OK</button>
                    <a href="ProdutoListar" class="btn btn-light col-1">Cancel</a>
                </form>
            </div>
        </main>
    </body>
</html>