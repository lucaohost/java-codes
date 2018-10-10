/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpagoverno;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpagoverno.pojo.Estado;
import jpagoverno.pojo.Governador;

/**
 *
 * @author Neiva
 */
public class JPAGoverno {

    /**
     * @param args the command line arguments
     */
    private static final String PERSISTENCE_UNIT_NAME = "JPAGovernoPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        try {
            persist();
        } catch (Exception ex) {
            Logger.getLogger(JPAGoverno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void persist() throws Exception {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select g from Governador g");
        boolean createNewEntries = (q.getResultList().isEmpty());
        if (createNewEntries) {
            Estado estado = new Estado();
            estado.setNome("Rio Grande do Sul");
            estado.setSigla("RS");
            em.persist(estado);
            Governador governador = new Governador();
            governador.setNome("Sartori");
            governador.setCpf("028.839.123.09");
            em.persist(governador);
            estado.setGovernador(governador);
            governador.setEstado(estado);
            em.persist(governador);
            em.persist(estado);
        }
        em.getTransaction().commit();
        em.close();
    }
}
