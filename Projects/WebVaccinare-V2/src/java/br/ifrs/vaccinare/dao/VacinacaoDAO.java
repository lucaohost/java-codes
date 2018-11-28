package br.ifrs.vaccinare.dao;

import br.ifrs.vaccinare.model.Crianca;
import br.ifrs.vaccinare.model.CriancaVacina;
import br.ifrs.vaccinare.model.Vacina;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class VacinacaoDAO {
    private EntityManager em;

    public void salvar(CriancaVacina criancaVacina) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(criancaVacina);
        this.em.getTransaction().commit();
        this.em.close();
    }
 

    public List<Vacina> pesquisar() throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Vacina> query = this.em.createQuery("Select c from Vacina c order by c.nome", Vacina.class);
        List<Vacina> vacinas = query.getResultList();
        this.em.close();
        return vacinas;
    }

    public List<Object[]> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        String sql = " Select c.id,c.nome,c.sexo,max(cv.data) from Crianca c ";
        sql +=       " join c.criancaVacinas cv ";
        sql +=       " where lower(c.nome) like :nome ";
        sql +=       " group by c.id";
        sql +=       " order by c.nome";
        TypedQuery<Object[]> query = this.em.createQuery(sql,Object[].class);
        query.setParameter("nome", "%"+nome.toLowerCase()+"%");        
        List<Object[]> vacinacoes = query.getResultList();
        this.em.close();
        return  vacinacoes;
    }
    
    public List<Object[]> obter(Long idCrianca) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        String sql = " Select v.nome, cv.lote, cv.data, c.nome from CriancaVacina cv ";
        sql +=       " join cv.vacina v ";
        sql +=       " join cv.crianca c ";
        sql +=       " where c.id = :id ";
        sql +=       " order by v.nome";
        TypedQuery<Object[]> query = this.em.createQuery(sql,Object[].class);
        query.setParameter("id", idCrianca);        
        List<Object[]> detalhesVacinacoes = query.getResultList();        
        this.em.close();
        return  detalhesVacinacoes;
    }
    
    

}
