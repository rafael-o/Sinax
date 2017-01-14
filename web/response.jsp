<%-- 
    Document   : response
    Created on : 12/01/2017, 16:10:20
    Author     : rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem de Cadastro</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="org.mypackage.objects.model.Musica" />
        <jsp:setProperty name="mybean" property="nome" />
        <jsp:setProperty name="mybean" property="cantor" />
        <jsp:setProperty name="mybean" property="album" />
        <jsp:setProperty name="mybean" property="genero" />
        
        <div id="tudo">
            <h1>Vitrola de Musicas</h1>
        
            <h2>A musica <jsp:getProperty name="mybean" property="nome" /> foi cadastrada com sucesso!</h2>
        </div>
    </body>
</html>
