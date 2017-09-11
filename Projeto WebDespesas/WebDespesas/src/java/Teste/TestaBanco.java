/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Despesa;
import model.Usuario;

/**
 *
 * @author aluno
 */
public class TestaBanco {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebDespesasPU");
        
        EntityManager em = emf.createEntityManager();
        
//        System.out.println("==> Conectou:" + em.isOpen());
//        
//        Usuario u = new Usuario(1, "Zezin da Sivla", "ze", "1234");
//        
//        em.getTransaction().begin();
//        em.persist(u);
//        em.getTransaction().commit();
//        

//Inserindo uusario
//        Usuario u = null;
//        Scanner le = new Scanner(System.in);
//
//        System.out.println("==> Conectou: " + em.isOpen());
//
//        //inserindo usuario
//        System.out.println("Deseje inserir um usuário?");
//        if (le.next().equalsIgnoreCase("s")) {
//            System.out.println("Nome do Usuário?");
//            u = new Usuario(null, "Zezin da Silva", "ze", "ze");//        
//            u.setNome(le.next());
//            em.getTransaction().begin();
//            em.persist(u);
//            em.getTransaction().commit();
//            System.out.println("Usuário Criado com Sucesso");
//        }
//        //Pesquisa pelo código
//        System.out.println("Digite um código a pesquisar?");
//        u = em.find(Usuario.class, le.nextInt());
//        if (u != null) {
//            System.out.println("==>" + u.getNome() + " - " + u.getDespesaList().size());
//            //Alterando
//            System.out.println("Deseja Alterar?");
//            if (le.next().equalsIgnoreCase("s")) {
//                System.out.println("Digite o novo Nome do Usuário?");
//                u.setNome(le.next());
//                Despesa d = new Despesa(null, new Date(), "Salário", true, 350.00);
//                d.setUsuario(u);
//                u.getDespesaList().add(d);
//                em.getTransaction().begin();
//                em.merge(u);
//                em.getTransaction().commit();
//                System.out.println("Usuário Alterado com Sucesso");
//            }
//            //Apagando
//            System.out.println("Deseja Apagar?");
//            if (le.next().equalsIgnoreCase("s")) {
//                em.getTransaction().begin();
//                em.remove(u);
//                em.getTransaction().commit();
//                System.out.println("Usuário Removido com Sucesso");
//            }
//        } else {
//            System.out.println("Usuário não encotrado!!!");
//        }
        


        //Consulta JPQL
        Query q = em.createQuery("select u from Usuario u where u.idusuario = 1");

        try{
            Usuario u1 = (Usuario)q.getSingleResult();
            System.out.println("==>" + u1.getNome());
        
        }catch(NoResultException e){
            System.out.println("Nenhum Usuario Encontrado");
        }catch(NonUniqueResultException e){
            System.out.println("Mais de um usuario encontrado");
            List<Usuario> listaU = q.getResultList();
            System.out.println("==>" + listaU.size());
        
        }
        
        q = em.createQuery("select d from Despesa d where d.usuario.nome like '%Pe%'");
        List<Despesa> listaDesp = q.getResultList();
        for(Despesa u2 : listaDesp){
            System.out.println("==>" + u2.getDescricao()+ " - " + u2.getUsuario().getNome());
        }
        
        //Fazendo consulta com NamedQuery
        q = em.createNamedQuery("Usuario.findByNome");
        q.setParameter("nome", "Gustin");
        Usuario u3 = (Usuario) q.getSingleResult();
        System.out.println("==>" + u3.getNome());
        
        
        em.close();
        emf.close();
        
    }
}
