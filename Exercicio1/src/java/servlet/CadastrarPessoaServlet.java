/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author aluno
 */
@WebServlet(name = "CadastrarPessoaServlet", urlPatterns = {"/CadastrarPessoa"})
public class CadastrarPessoaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            /* TODO output your page here. You may use following sample code. */
            
            Pessoa p = new Pessoa();
            p.setNome(request.getParameter("cpNome"));
            p.setDescricao(request.getParameter("cpDescreva"));
            p.setSexo(request.getParameter("cpSexo"));
            p.setIdade(Integer.parseInt(request.getParameter("cpIdade")));
            if(request.getParameterValues("cpPreferencia") != null){
                String[] preferencias = (String[])request.getParameterValues("cpPreferencia");
                for (int i = 0; i < preferencias.length; i++) {
                    p.addPreferencia(preferencias[i]);
                }
            }
            
     //Primeira forma de esposta, escreve pagina ao cliente
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CadastrarPessoaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            
//            out.println("<table border = 1>");
//            out.println("<tr>");
//            out.println("<td colspan=2>");
//            out.println("<h2 align='center'>Perfil Cadastrado</h2>");
//            out.println("</td>");
//            out.println("</tr>");
//            out.println("<tr>");
//            out.println("<td>Nome:</td><td>"+ p.getNome() +"</td>");
//            out.println("</tr>");
//            out.println("<tr>");
//            out.println("<td>Sexo:</td><td>"+ p.SexoToString()+"</td>");
//            out.println("</tr>");
//            out.println("<tr>");
//            out.println("<td>Idade:</td><td>"+ p.FaixaIdadeString()+"</td>");
//            out.println("</tr>");
//            out.println("<tr>");
//            out.println("<td>Preferencias:</td><td><ul>");
//            for (int j = 0; j < p.getPreferencias().size(); j++) {
//                out.println("<li>"+ p.getPreferencias().get(j) +"</li>");
//            }
//            out.println("</ul></td>");
//            out.println("</tr>");
//            out.println("<tr>");
//            out.println("<td>Descrição:</td><td>"+ p.getDescricao()+"</td>");
//            out.println("</tr>");
//            out.println("</table>");
//            out.println("</body>");
//            out.println("</html>");
//        }

    //Segunda forma de resposta, recirecionar para o cliente
        //response.sendRedirect("resposta.jsp?cpNome=" + p.getNome() + "&sexo=" + p.SexoToString());
        
        //Terceira forma de resposta, reencaminhar para o cliente
        RequestDispatcher rd = request.getRequestDispatcher("resposta.jsp");
        request.setAttribute("pessoa", p);
        
        rd.forward(request, response);
        
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
