/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.util.List;
import javax.persistence.Query;
import model.Professor;
import model.Turma;
import model.dao.DAO;

/**
 *
 * @author aluno
 */
public class TurmaDao extends DAO<Turma, Integer> {

    @Override
    public Turma save(Turma obj) {
        try {
            getConnection().getTransaction().begin();
            getConnection().persist(obj);
            getConnection().getTransaction().commit();

        } catch (Exception e) {
            getConnection().getTransaction().rollback();
        }

        return obj;
    }

    public Turma edit(Turma obj) {
        try {
            getConnection().getTransaction().begin();
            getConnection().merge(obj);
            getConnection().getTransaction().commit();

        } catch (Exception e) {
            getConnection().getTransaction().rollback();
        }
        return obj;
    }

    @Override
    public Turma findOne(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> findAll() {
        try {
            Query q = getConnection().createNamedQuery("Turma.findAll");

            return q.getResultList();

        } finally {
            //close();
        }

    }

    public List<Turma> findByAnoAndSemestreAndProfessorAndDisciplina
        (int ano, int semestre, int idProfessor, int idDisciplina) {
        String hql = "select t from Turma t"
                + " where 1 = 1 ";
        if (ano >0){hql += " and t.ano = :ano  ";}
        if (semestre >0){hql += " and t.semestre = :semestre  ";}
        if (idProfessor >0){hql += " and t.professor.idprofessor = :prof  ";}
        if (idDisciplina >0){hql += " and t.disciplina.iddisciplina = :disc  ";}

        Query q = getConnection().createQuery(hql);

        if (ano >0){ q.setParameter("ano", ano);} 
        if (semestre >0){ q.setParameter("semestre", semestre);} 
        if (idProfessor >0){ q.setParameter("prof", idProfessor);} 
        if (idDisciplina >0){ q.setParameter("disc", idDisciplina);} 
        
        return q.getResultList();
    }

}
