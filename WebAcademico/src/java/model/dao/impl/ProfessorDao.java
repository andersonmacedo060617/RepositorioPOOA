/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Professor;
import model.dao.DAO;

/**
 *
 * @author aluno
 */
public class ProfessorDao extends DAO<Professor, Integer> {

    public Professor findLoginAndPassword(String login, String senha) {

        Query q = getConnection().createQuery("Select p from Professor p "
                + "Where p.email = :log and p.senha = :sen ");

        q.setParameter("log", login);
        q.setParameter("sen", senha);
        try {
            return (Professor) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Professor save(Professor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professor findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Professor> findAll() {
    try {
            Query q = getConnection().createNamedQuery("Professor.findAll");

            return q.getResultList();

        } finally {
            //close();
        }     
    
    }

}
