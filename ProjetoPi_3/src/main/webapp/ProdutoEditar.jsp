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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
    <body>
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
    </body>
</html>