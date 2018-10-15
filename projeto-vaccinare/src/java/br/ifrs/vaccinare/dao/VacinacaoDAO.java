/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.vaccinare.dao;

import br.ifrs.vaccinare.model.Crianca;
import br.ifrs.vaccinare.model.Vacinacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class VacinacaoDAO {

    private EntityManager em;

    public void salvar(Vacinacao vacinacao) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        long idKid = vacinacao.getCrianca().getId();

        //tira a ultimaVacinacao
        TypedQuery<Vacinacao> query = this.em.createQuery(" Select v from Vacinacao v where v.ultimaVacinacao = 1 and v.crianca.id = :idKid", Vacinacao.class);
        query.setParameter("idKid", idKid);
        if (query.getResultList().size() > 0) {
            Vacinacao lastVacina = query.getResultList().get(0);
            lastVacina.setUltimaVacinacao(false);
            this.em.getTransaction().commit();
            this.em.getTransaction().begin();
        }

        // insere a ultima vacinacao
        this.em.persist(vacinacao);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<Vacinacao> pesquisarUltimasVacinas(String nomeCrianca) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Vacinacao> query = this.em.createQuery(" Select v from Vacinacao v where v.ultimaVacinacao = 1", Vacinacao.class);
        List<Vacinacao> vacinas = query.getResultList();
//        compra id das crianças achadas e tira as que não estiverem no array de vacinas
//        TypedQuery<Crianca> queryKids = this.em.createQuery(" Select c from Crianca c where c.nome like '%J%'",Crianca.class);
//        List<Crianca> criancas = queryKids.getResultList();
        this.em.close();

        return vacinas;
    }

    public List<Vacinacao> pesquisarPorIdCrianca(Long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Vacinacao> query = this.em.createQuery(" Select v from Vacinacao v where v.crianca.id = :id", Vacinacao.class);
        query.setParameter("id", id);
        List<Vacinacao> vacinas = query.getResultList();
        this.em.close();
        return vacinas;
    }
}
