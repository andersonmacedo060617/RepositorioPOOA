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
import model.Turma;
import model.dao.DAO;

/**
 *
 * @author aluno
 */
public class TurmaDAO extends DAO<Turma, Integer>{

    
    
   

    @Override
    public Turma delete(Turma obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turma save(Turma obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turma findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> findAll() {
        try{
            Query q = getConnection().createNamedQuery("Turma.findAll");
            
            return q.getResultList();
        }finally{
            //close();
        }
    }
    
}
