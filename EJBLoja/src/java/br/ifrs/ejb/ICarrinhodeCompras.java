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
public interface ICarrinhodeCompras {
    
    public void adicionarItem(String item);
    
    public void removerItem(String item);
    
    public void remover();
    
    @Override
    public String toString();
    
    public ArrayList<String> getItens();
}
