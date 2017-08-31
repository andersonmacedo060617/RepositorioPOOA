<%-- 
    Document   : index
    Created on : 31/08/2017, 19:38:46
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            #frm{
                background: red;
                border: 1px solid gray;
            }
        </style>
    </head>
    <body>
        <h1>Login</h1>
        <fieldset>
            <legend>Informe o Login.</legend>
            <form id="frm" action="control" method="post">
                Login:<input type="text" name="cpLogin" /><br />
                Senha:<input type="password" name="cpSenha" /><br />
                <br />
                <br />
                <input type="submit" value="Ok" />
                <%= request.getAttribute("erro")!= null?request.getAttribute("erro"):"" %>
            </form>
        </fieldset>
    </body>
</html>
