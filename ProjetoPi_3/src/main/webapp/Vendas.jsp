<%-- 
    Document   : Vendas
    Created on : 28/10/2020, 22:43:19
    Author     : Jardel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <main role="main">
            <div class="container">
                <h1>Vendas</h1>

                <form action="Vendas" method="POST">
                    <div class="form-group">
                        <label for="Produto">Produto</label>
                        <input type="text" class="form-control" id="produto"  name="produto">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="quantidade">Quantidade</label>
                            <input type="number" class="form-control"  id= "quantidade" name="quantidade">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="unidade">Unidade</label>
                            <input type="text" class="form-control" placeholder="Opcional" id="unidade"  name="unidade">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="categoria">Categoria</label>
                            <input type="text" class="form-control" id="categoria" name="categoria"                      
                        </div>
                    </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="Vendedor">Vendedor</label>
                    <input type="text" class="form-control" placeholder="Nome completo" id= "vendedor" name="vendedor">
                </div>
                <div class="form-group col-md-2">
                    <label for="cliente">Cliente</label>
                    <input type="text" class="form-control" placeholder="CPF" id="cliente"  name="cliente">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="desconto">Desconto</label>
                    <input type="text" class="form-control" placeholder="000,0%" id="desconto"  name="desconto">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="Total">Total a pagar:</label>
                    <input type="text" class="form-control" placeholder="R$0" id="total"  name="desconto">
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-primary col-1">OK</button>
                <a href="ProdutoListar" class="btn btn-danger col-1">Cancel</a>

            </div>

        </form>
    </div>
</main>
</body>
</html>
