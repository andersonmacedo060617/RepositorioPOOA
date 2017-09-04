<%-- 
    Document   : home
    Created on : 31/08/2017, 19:34:41
    Author     : aluno
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="control?op=sair">Sair</a>
        
        <form action="control" method="POST">
            <input type="hidden" name="op" value="cad" />
            <input type="submit" value="Cadastro" />
        </form>
    </body>
</html>
