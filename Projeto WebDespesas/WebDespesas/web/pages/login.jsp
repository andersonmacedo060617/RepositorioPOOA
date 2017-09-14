<%-- 
    Document   : calculadora
    Created on : 14/03/2017, 16:05:29
    Author     : daves
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="home" method="POST">
    <input type="hidden" name="ac" value="verificaLogin"/>
    <c:if test="${requestScope.msg != null}" >
        <div style="color:green">${requestScope.msg}</div>
    </c:if>
    Login: <input type="text" name="cpLogin" value="" placeholder="0" /><br />
    Senha: <input type="password" name="cpSenha" value="" placeholder="0"/><br />
    <input type="submit" value="Logar" name="btn" />
    <%
    String erro = (String)request.getAttribute("erro");


    if(erro != null){
        out.print("<div style=\"color:red\">" +
                erro + "</div>");
    }
    %>
    <c:if test="${requestScope.erro != null}" >
        <div style="color:red">${requestScope.erro}</div>
    </c:if>
</form>
