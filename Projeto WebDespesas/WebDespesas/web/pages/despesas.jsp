<%-- 
    Document   : calculadora
    Created on : 14/03/2017, 16:05:29
    Author     : daves
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="home"/>
</c:if>
Despesas do ${sessionScope.user.nome},
<br><br>
Menu<br>
<a href="home?ac=ListDespesas">Despesas<br></a>
<a href="home?ac=Home">Voltar<br></a>
-----------<br>
<a href="home?ac=Deslogar">Sair<br></a>

                                             