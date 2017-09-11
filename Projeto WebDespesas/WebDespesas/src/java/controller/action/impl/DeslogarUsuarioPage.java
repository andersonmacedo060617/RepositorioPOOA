/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl;

import controller.action.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 *
 * @author aluno
 */
public class DeslogarUsuarioPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        request.setAttribute("msg", "Usuario Deslogado!");
        
    }
    
}
