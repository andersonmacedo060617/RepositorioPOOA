/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Disciplina;
import model.Professor;
import model.Turma;
import model.dao.DAO;

/**
 *
 * @author aluno
 */
public class DisciplinaDao extends DAO<Disciplina, Integer> {

    @Override
    public Disciplina save(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Disciplina findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disciplina> findAll() {
       try {
            Query q = getConnection().createNamedQuery("Disciplina.findAll");

            return q.getResultList();

        } finally {
            //close();
        } 
    }


}
