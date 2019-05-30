/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.ejb;

import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Neiva
 */
@Stateful
public class CarrinhodeCompras implements ICarrinhodeCompras{
    private ArrayList<String> itens;
    
    public CarrinhodeCompras(){
        this.itens = new ArrayList<>();
    }
    
    @Override
    public void adicionarItem(String item) {
        this.itens.add(item);
    }

    @Override
    public void removerItem(String item) {
        this.itens.remove(item);
    }

    @Override
    @Remove
    public void remover() {
        this.itens.clear();
    }

    @Override
    public String toString() {
        return "CarrinhodeCompras{" + "itens=" + itens + '}';
    }

    public ArrayList<String> getItens() {
        return itens;
    }
}
