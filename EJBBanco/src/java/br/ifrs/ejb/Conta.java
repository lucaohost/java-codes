/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author lucaxrl
 */
@Stateless
public class Conta implements IConta {
        float total;
    @Override
    public float debitar(float quantidade) {
        this.total -= quantidade;
        return this.total;
    }

    @Override
    public void depositar(float quantidade) {
        this.total += quantidade;
    }
    
    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct com sucesso.");
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("Pré Destroy com sucesso.");
    }
}
