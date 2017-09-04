/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl;

import controller.action.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class VerifyUserLoginPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter("cpLogin");
        String senha = request.getParameter("cpSenha");
        
        String sql = "select u from Usuario u where "
                + " u.login = :u and u.senha = :senha";
    }
    
}
