<%-- 
    Document   : erro
    Created on : 29/10/2020, 13:55:47
    Author     : Lucas Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro!</title>
    </head>
    <body>
        <h1>Erro!</h1>
        <br/>
        ${msgErro}
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
