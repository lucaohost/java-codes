/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpabiblioteca;

import jpabiblioteca.dao.LivroDAO;
import jpabiblioteca.pojo.Livro;

/**
 *
 * @author Neiva
 */
public class JPABiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAO();
        
        Livro livro  = new Livro();
        livro.setAutor("Jorge");
        livro.setIsbn("123123188");
        livro.setPaginas(499);
        livro.setPreco(24.99);
        livro.setTitulo("O Enigma do Príncipe");
        livroDAO.salvar(livro);
        System.out.println("Livro do Jorge inserido.");
        
        Livro livro2  = new Livro();
        livro2.setAutor("Lucas");
        livro2.setIsbn("123123199");
        livro2.setPaginas(499);
        livro2.setPreco(24.99);
        livro2.setTitulo("O Prisioneiro de Azkaban");
        livroDAO.salvar(livro2);
        System.out.println("Livro do Lucas inserido.");
        
        livroDAO.excluir("123123188");
        System.out.println("Livro do Jorge excluido");
    }
    
}
