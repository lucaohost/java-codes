/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpafamilia;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpafamilia.pojo.Familia;
import jpafamilia.pojo.Pessoa;

/**
 *
 * @author Mauri
 */
public class JPAFamilia {

    /**
     * @param args the command line arguments
     */
    
    private static final String PERSISTENCE_UNIT_NAME = "JPAFamiliaPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        try {
            setUp();
            checkAvailablePeople();
            checkFamily();
            deletePerson();
        } catch (Exception ex) {
            Logger.getLogger(JPAFamilia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setUp() throws Exception {
    
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        // Comece uma nova transação local para que possamos persistir uma nova entidade
        em.getTransaction().begin();

        // leia as entradas existentes
        Query q = em.createQuery("select m from Pessoa m");
        // As pessoas devem estar vazias
        // nós temos registros no banco de dados?
        boolean createNewEntries = (q.getResultList().isEmpty());

        // Não, então vamos criar novas entradas
        if (createNewEntries) {
            System.out.println("Adicionando pessoas na base de dados");
            
            Familia familia = new Familia();
            familia.setDescricao("Family for the Knopfs");
            em.persist(familia);
            for (int i = 0; i < 40; i++) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome("Jim_" + i);
                pessoa.setSobrenome("Knopf_" + i);
                em.persist(pessoa);
                // agora persiste o relacionamento da familia e pessoa
                familia.getMembros().add(pessoa);
                em.persist(pessoa);
                em.persist(familia);
            }
        }
        
        // Confirme a transação, o que fará com que 
        // a entidade seja armazenada no banco de dados
        em.getTransaction().commit();

        // É sempre uma boa prática fechar o EntityManager 
        // para que os recursos sejam conservados.
        em.close();

    }
    
    public static void checkAvailablePeople() {

        // Agora vamos verificar o banco de dados e ver se as entradas criadas estão lá 
        // e criar um novo EntityManager
        EntityManager em = factory.createEntityManager();

        // Realize uma consulta simples para todas as entidades Pessoa
        Query q = em.createQuery("select m from Pessoa m");

        // Devemos ter 40 pessoas no banco de dados
        System.out.println("Pessoas na Base de Dados: "+ q.getResultList().size());

        em.close();
    }

    public static void checkFamily() {
        EntityManager em = factory.createEntityManager();
        // Percorra cada uma das entidades e imprima cada um de seus dados        
        Query q = em.createQuery("select f from Familia f");

        // Nós devemos ter uma família com 40 pessoas
        System.out.println("Numero de Famílias: "+q.getResultList().size());
        System.out.println("Numero de Membros: "+((Familia) q.getSingleResult()).getMembros().size());
        em.close();
    }
    
    public static void deletePerson() {
        EntityManager em = factory.createEntityManager();
        // Comece uma nova transação local para que possamos apagar uma entidade existente no banco
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Pessoa p WHERE p.nome = :nome AND p.sobrenome = :sobrenome");
        q.setParameter("nome", "Jim_1");
        q.setParameter("sobrenome", "Knopf_1");
        Pessoa user = (Pessoa) q.getSingleResult();
        em.remove(user);
        em.getTransaction().commit();
        System.out.println("Apagou Jim_1 Knopf_1");        

        em.close();
    }
    
}
