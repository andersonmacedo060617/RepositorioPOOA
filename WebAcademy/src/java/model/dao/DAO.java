/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public abstract class DAO<C, k> {

    private EntityManager em;
    private EntityManagerFactory emf;


    public DAO() {
        emf = Persistence.createEntityManagerFactory("WebAcademyPU");
        em = emf.createEntityManager();
    }
    
    public EntityManager getConnection() {
        return em;
    }
    
    public void close(){
        if(em.isOpen()){
            em.close();
            emf.close();
        }
    }
    
    public abstract C delete(C obj);
    public abstract C save(C obj);
    public abstract C findOne(k key);
    public abstract List<C> findAll();
    
    
}
