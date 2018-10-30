/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacomercio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpacomercio.pojo.Cliente;
import jpacomercio.pojo.Pedido;

/**
 *
 * @author Neiva
 */
public class JPAComercio {

    /**
     * @param args the command line arguments
     */
    private static final String PERSISTENCE_UNIT_NAME = "JPAComercioPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        try {
            persist();
        } catch (Exception ex) {
            Logger.getLogger(JPAComercio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void persist() throws Exception {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select c from Cliente c");
        boolean createNewEntries = (q.getResultList().isEmpty());
        if (createNewEntries) {
            Pedido ped = new Pedido();
            ped.setNomeProduto("Mouse Gamer");
            ped.setQuantidade(2);
            ped.setData("22/04/18");
            ped.setValor(95.99);
            Cliente cli = new Cliente();
            cli.setNome("Jonas");
            cli.setCnpj("028.991.109/88");
            cli.setEndereco("Rua Caomburiú");
            ped.setCliente(cli);
            em.persist(cli);
            em.persist(ped);
        }
        em.getTransaction().commit();
        em.close();
    }
    
}
