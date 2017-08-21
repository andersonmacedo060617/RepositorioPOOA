<%-- 
    Document   : resposta
    Created on : 21/08/2017, 19:31:44
    Author     : aluno
--%>

<%@page import="Model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Perfil</h1>
        
        <%
            Pessoa pessoa = (Pessoa)request.getAttribute("pessoa");
        %>
        
        <table border = 1> 
            <tr> 
                <td colspan=2> 
                    <h2 align='center'>Perfil Cadastrado</h2> 
                </td> 
            </tr> 
            <tr> 
                <td>Nome:</td>
                <td>
                    <%out.print(pessoa.getNome()); %>
                </td> 
            </tr> 
            <tr> 
                <td>Sexo:</td>
                <td><%out.print(pessoa.SexoToString()); %></td> 
            </tr> 
            <tr> 
                <td>Idade:</td>
                <td><%out.print(pessoa.FaixaIdadeString()); %></td> 
            </tr> 
            <tr> 
                <td>Preferencias:</td>
                <td><ul>
                    <%
                        for (Object pref : pessoa.getPreferencias()) {
                            %>
                            <li>
                                <%
                                  out.print(pref.toString());
                                %>
                            </li>
                            <%
                        }
 
                    %>
                </ul></td> 
            </tr> 
            <tr> 
                <td>Descrição:</td>
                <td><%out.print(pessoa.getDescricao());%></td> 
            </tr> 
        </table> 
    </body>
</html>
