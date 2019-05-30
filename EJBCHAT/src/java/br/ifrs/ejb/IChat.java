/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.ejb;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Neiva
 */
@Remote
public interface IChat {    
    public void criarSala(String sala);
    
    public String listaSalas(); 
    
    public ArrayList<String> getSalas();
}
