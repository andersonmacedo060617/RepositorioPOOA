/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Aluno;
import model.Professor;
import model.dao.DAO;

/**
 *
 * @author aluno
 */
public class AlunoDao extends DAO<Aluno, Integer> {

    @Override
    public Aluno save(Aluno obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> findAll() {
        Query q = getConnection().createNamedQuery("Aluno.findAll");

        return q.getResultList();
    }

}
