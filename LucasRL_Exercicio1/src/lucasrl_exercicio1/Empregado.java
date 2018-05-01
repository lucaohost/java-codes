/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasrl_exercicio1;

/**
 *
 * @author lucaxrl
 */
public class Empregado {
    private String nome;
    private double valorHora;
    private double numeroHoras;

    public Empregado(String nome, double valorHora, double numeroHoras) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.numeroHoras = numeroHoras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(double numeroHoras) {
        this.numeroHoras = numeroHoras;
    }
    
    public void calculaSalario(){
        
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Salário p/hora: " + valorHora + ", Horas Trabalhadas: " + numeroHoras;
    }
    
}
