/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.Professor;
import model.dao.DAO;

/**
 *
 * @author aluno
 */
public class ProfessorDAO extends DAO<Professor, Integer>{

    
    @Override
    public Professor delete(Professor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Professor findLoginAndaPassword(String login, String senha) {

        
        Query q = getConnection().createQuery("SELECT p FROM Professor p "
            + " WHERE p.email = :log and p.senha = :sen");
        q.setParameter("log", login);
        q.setParameter("sen", senha);
        try{
            return (Professor) q.getSingleResult();
        }catch(Exception e){
            return null;
        }finally{
            close();
        }
        
    }
    
}
