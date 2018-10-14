/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.vaccinare.dao;

import br.ifrs.vaccinare.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO {
    private EntityManager em;

    public Usuario pesquisar(String login, String senha) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Usuario> query = this.em.createQuery(" Select u from Usuario u where u.login = :login and u.senha = :senha",Usuario.class);
        query.setParameter("login",login);        
        query.setParameter("senha",senha);        
        List<Usuario> usuario = query.getResultList();
        this.em.close();
        if(usuario.size() > 0 ){
            return usuario.get(0);
        }else{
            return null;
        }
    }
  
}
