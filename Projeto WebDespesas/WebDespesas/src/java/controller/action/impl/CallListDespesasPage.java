/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl;

import controller.action.ICommand;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Despesa;
import model.dao.DespesaDAO;

/**
 *
 * @author aluno
 */
public class CallListDespesasPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=listaDespesas");
        List<Despesa> lstDespesas = new DespesaDAO().findAll();
        request.setAttribute("lstDespesas", lstDespesas);
        rd.forward(request, response);
    }
    
}
