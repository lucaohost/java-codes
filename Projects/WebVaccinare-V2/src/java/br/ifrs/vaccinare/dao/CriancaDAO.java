package br.ifrs.vaccinare.dao;

import br.ifrs.vaccinare.model.Crianca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CriancaDAO {

    private EntityManager em;

    public void salvar(Crianca crianca) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(crianca);
        this.em.getTransaction().commit();
        this.em.close();
    }
 
    public void atualizar(Crianca crianca) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(crianca);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(Long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Crianca entity = this.em.find(Crianca.class, id);
        if (entity != null) {
            this.em.remove(entity);
        } 
        this.em.getTransaction().commit();
        this.em.close();
    }

    public Crianca obter(Long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        Crianca crianca = this.em.find(Crianca.class, id);
        this.em.close();
        return crianca;
    }

    public List<Crianca> pesquisar() throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Crianca> query = this.em.createQuery("Select c from Crianca c order by c.nome", Crianca.class);
        List<Crianca> criancas = query.getResultList();
        this.em.close();
        return criancas;
    }

    public List<Crianca> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Crianca> query = this.em.createQuery(" Select c from Crianca c where lower(c.nome) like :nome order by c.nome",Crianca.class);
        query.setParameter("nome", "%"+nome.toLowerCase()+"%");        
        List<Crianca> criancas = query.getResultList();
        this.em.close();
        return criancas;
    }

}
