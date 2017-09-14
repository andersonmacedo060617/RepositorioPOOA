<%-- 
    Document   : calculadora
    Created on : 14/03/2017, 16:05:29
    Author     : daves
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML>
<!--
	Identity by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<c:if test="${sessionScope.user == null}">
    
    <c:redirect url="home"/>
</c:if>

Olá ${sessionScope.user.nome},
<br><br>
Menu<br>
Home<br>
<a href="home?ac=CadDespesa">Despesas<br></a>  
Categorias<br>
Relatório<br>
-----------<br>
<a href="home?ac=Deslogar">Sair<br></a>
<hr />

