/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaempresa;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpaempresa.pojo.Departamento;
import jpaempresa.pojo.Funcionario;

/**
 *
 * @author Neiva
 */
public class JPAEmpresa {

    /**
     * @param args the command line arguments
     */
    private static final String PERSISTENCE_UNIT_NAME = "JPAEmpresaPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        try {
            persist();
        } catch (Exception ex) {
            Logger.getLogger(JPAEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void persist() throws Exception {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select f from Funcionario F");
        boolean createNewEntries = (q.getResultList().isEmpty());
        if (createNewEntries) {
            Departamento dep = new Departamento();
            dep.setNome("TI");
            dep.setDescricao("Melhor Departamento de Todos");
            em.persist(dep);
            Funcionario fun = new Funcionario();
            fun.setNome("Jonas");
            fun.setCpf("028.839.123.09");
            Funcionario fun2 = new Funcionario();
            fun2.setNome("Douglas");
            fun2.setCpf("018.866.112.99");
            dep.getMembros().add(fun);
            dep.getMembros().add(fun2);
            em.persist(fun2);
            em.persist(fun);
            em.persist(dep);
        }
        em.getTransaction().commit();
        em.close();
    }
}
