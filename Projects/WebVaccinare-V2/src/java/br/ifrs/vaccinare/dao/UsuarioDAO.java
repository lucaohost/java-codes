package br.ifrs.vaccinare.dao;

import br.ifrs.vaccinare.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UsuarioDAO {

    private EntityManager em;

    public Usuario logar(String email, String senha) throws Exception {
        
        this.em = EntityManagerProvider.getInstance();

        
        TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where lower(u.email) = :email and u.senha = :senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        List<Usuario> usuarios = query.getResultList();
        this.em.close();
        if (usuarios.size() > 0) {
            return usuarios.get(0);
        } else {
            return null;
        }

    }

    public boolean verificarEmail(String email) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where lower(u.email) = :email", Usuario.class);
        query.setParameter("email", email);
        List<Usuario> usuarios = query.getResultList();
        this.em.close();
        if (usuarios.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public void atualizar(Usuario user) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(user);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void salvar(Usuario user) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(user);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<Usuario> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Usuario> query = this.em.createQuery(" Select u from Usuario u where lower(u.nome) like :nome order by u.nome", Usuario.class);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");
        List<Usuario> users = query.getResultList();
        this.em.close();
        return users;
    }

    public Usuario obter(int idUsuarioDB) {
        this.em = EntityManagerProvider.getInstance();
        Usuario usuarioDB = this.em.find(Usuario.class, idUsuarioDB);
        this.em.close();
        return usuarioDB;
    }
    
    public void excluir(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Usuario entity = this.em.find(Usuario.class, id);
        if (entity != null) {
            this.em.remove(entity);
        } 
        this.em.getTransaction().commit();
        this.em.close();
    }

}
