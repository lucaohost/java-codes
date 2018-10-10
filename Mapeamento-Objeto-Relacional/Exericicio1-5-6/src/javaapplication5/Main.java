/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import model.Mensagem;
import model.Usuario;

/**
 *
 * @author Neiva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Inserindo Usuário Lucas\n.");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario user = new Usuario();
        user.setNome("Lucas");
        usuarioDAO.persist(user);
        System.out.println("Usuário Lucas inserido.\n");
        
        System.out.println("Inserindo log de mensagem.\n");
        MensagemDAO mensagemDAO = new MensagemDAO();
        Mensagem mensagem = new Mensagem();
        mensagem.setMensagem("Funcionou!");
        mensagemDAO.persist(mensagem);
        System.out.println("Log de mensagem inserido.\n");
    }
    
}
