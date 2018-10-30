/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalivraria;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpalivraria.pojo.Autor;
import jpalivraria.pojo.Livro;

/**
 *
 * @author Neiva
 */
public class JPALivraria {

    /**
     * @param args the command line arguments
     */
    private static final String PERSISTENCE_UNIT_NAME = "JPALivrariaPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        try {
            persist();
        } catch (Exception ex) {
            Logger.getLogger(JPALivraria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void persist() throws Exception {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select l from Livro l");
        boolean createNewEntries = (q.getResultList().isEmpty());
        if (createNewEntries) {
            Livro livro = new Livro();
            livro.setNome("O Cálice de Fogo");
            livro.setCodigoISBN("93-923423883.3");
            em.persist(livro);
            Autor aut = new Autor();
            aut.setNome("Jonas");
            aut.setPseudonimo("Fernando");
            Autor aut2 = new Autor();
            aut2.setNome("Douglas");
            aut2.setPseudonimo("Julio");
            aut.getLivros().add(livro);
            aut2.getLivros().add(livro);
            em.persist(aut2);
            em.persist(aut);
            em.persist(livro);
        }
        em.getTransaction().commit();
        em.close();
    }
    
}
