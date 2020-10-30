<%-- 
    Document   : cadastrarCliente
    Created on : 29/10/2020, 13:34:03
    Author     : Lucas Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarCliente" method="POST">
            <p>Nome</p>
            <input name="nome" class="form-control" required="true"/><br/>
            <p>Email</p>
            <input name="email" class="form-control" required="true"/><br/>
            <p>CPF</p>
            <input name="cpf" class="form-control" required="true"/><br/>
            
            <button type="submit" class="btn btn-primary">Enviar</button>
            
        </form>
    </body>
</html>
