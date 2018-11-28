package br.ifrs.vaccinare.dao;

import br.ifrs.vaccinare.model.Vacina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

public class VacinaDAO {

    private EntityManager em;

    public List<Vacina> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Vacina> query = this.em.createQuery(" Select v from Vacina v where lower(v.nome) like :nome order by v.nome", Vacina.class);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");
        List<Vacina> vacinas = query.getResultList();
        this.em.close();
        
        vacinas.forEach((vacina) -> {
            vacina.setCriancaVacinas(null);
        });
        return vacinas;
    }

    public Vacina obter(Long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        Vacina vacina = this.em.find(Vacina.class, id);
        this.em.close();
        return vacina;
    }

    public void excluir(Long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Vacina entity = this.em.find(Vacina.class, id);
        if (entity != null) {
            this.em.remove(entity);
        }
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void salvar(Vacina vacina) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(vacina);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void atualizar(Vacina vacina) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(vacina);
        this.em.getTransaction().commit();
        this.em.close();
    }

}
