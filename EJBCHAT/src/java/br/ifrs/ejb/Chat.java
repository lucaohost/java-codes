/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.ejb;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author Neiva
 */
@Singleton
public class Chat implements IChat {

    private ArrayList<String> salas;
    
    public Chat(){
        this.salas = new ArrayList<>();
    }

    public ArrayList<String> getSalas() {
        return salas;
    }

    @Override
    public void criarSala(String sala) {
        this.salas.add(sala);
    }

    @Override
    public String listaSalas() {
        String listaSalas = "";
        for (String sala : this.salas) {
            listaSalas += "Sala: " + sala + "\n";
        }
        return listaSalas;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct com sucesso.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Pré Destroy com sucesso.");
    }
}
