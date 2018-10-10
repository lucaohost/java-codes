/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public List<Crianca> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Crianca> query = this.em.createQuery(" Select c from Crianca c where lower(c.nome) like :nome order by c.nome",Crianca.class);
        query.setParameter("nome", "%"+nome.toLowerCase()+"%");        
        List<Crianca> criancas = query.getResultList();
        this.em.close();
        return criancas;
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
    
     public Crianca pesquisarPorId(Long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Crianca> query = this.em.createQuery(" Select c from Crianca c where id = :id",Crianca.class);
        query.setParameter("id", id);        
        List<Crianca> criancas = query.getResultList();
        this.em.close();
        return criancas.get(0);
    }
  
}
