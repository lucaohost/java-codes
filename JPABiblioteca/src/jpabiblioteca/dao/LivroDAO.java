/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpabiblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpabiblioteca.pojo.Livro;

/**
 *
 * @author Neiva
 */
public class LivroDAO {

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivroDAO");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void salvar(Livro object) {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Livro consultarPorId(int id) {
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT l FROM Livro l WHERE l.id = :id");
        q.setParameter("id", id);
        Livro livro = (Livro) q.getSingleResult();
        return livro;
    }
    
    public void excluir(String isbn){
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT l FROM Livro l WHERE l.isbn = :isbn");
        q.setParameter("isbn", isbn);
        Livro livro = (Livro) q.getSingleResult();
        System.out.println("Apagou o livro de ISBN " + livro.getIsbn());        
        em.remove(livro);
        em.getTransaction().commit();
        em.close();
    }
}
