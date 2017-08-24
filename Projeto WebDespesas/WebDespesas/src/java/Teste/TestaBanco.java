/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

/**
 *
 * @author aluno
 */
public class TestaBanco {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebDespesasPU");
        
        EntityManager em = emf.createEntityManager();
        
        System.out.println("==> Conectou:" + em.isOpen());
        
        Usuario u = new Usuario(1, "Zezin da Sivla", "ze", "1234");
        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
}
