<%-- 
    Document   : calculadora
    Created on : 14/03/2017, 16:05:29
    Author     : daves
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<fildset>
    <legend>Pesquisa</legend>
    <form>

    </form>
</fildset>
<div id="grid">
    <table>
        <tr>
            <th>Id</th>
            <th>Data</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Categoria</th>
            <th>Usuario</th>
            <th>Paga?</th>
            <th>Comandos</th>
        </tr>
        <c:forEach items="${requestScope.lstDespesas}" var="despesa">
        <tr>
            <td>${despesa.id}</td>
            <td><fmt:formatDate value="${despesa.datadespesa}" pattern="dd/MM/yyyy"/> </td>
            <td>${despesa.descricao}</td>
            <td><fmt:formatNumber value="${despesa.valor}" pattern="#0.00" /> </td>
            <td>${despesa.categoriaId.nomeCategoria}</td>
            <td>${despesa.usuario.nome}</td>
            <td>${despesa.paga}</td>
            <td>X A</td>
        </tr>
        </c:forEach>
    </table>
</div>

					