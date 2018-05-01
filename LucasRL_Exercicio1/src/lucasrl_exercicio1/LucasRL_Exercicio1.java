/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasrl_exercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucaxrl
 */
public class LucasRL_Exercicio1 {
    public static void main(String[] args) {
        ArrayList<Empregado> empregados = new ArrayList<>();
        Scanner leitor = new Scanner (System.in);
        int option = 0;
        do{
            System.out.println("1: Cadastrar Empregado.");
            System.out.println("2: Listar Empregados.");
            System.out.println("3: Pesquisar por nome.");
            System.out.println("0: Sair.");
            option = leitor.nextInt();
            switch (option) {
                case 1:
                    limpa();
                    System.out.println("Digite o Nome do empregado:\n");
                    String nome = leitor.next();
                    System.out.println("Digite o Salário p/hora do empregado:\n");
                    double salario =  leitor.nextDouble();
                    System.out.println("Digite o número de horas trabalhadas do empregado:\n");
                    double horas = leitor.nextDouble();
                    Empregado ep = new Empregado(nome,salario,horas);
                    empregados.add(ep);
                    break;
                case 2:
                    limpa();
                    empregados.forEach((empregado) -> {
                        System.out.println("\n");
                        System.out.println(empregado);
                    });
                    break;
                case 3:
                    limpa();
                    System.out.println("Digite o nome do empregado:\n");
                    String nomePesquisado = leitor.next();
                    empregados.forEach((empregado) -> {
                        if(empregado.getNome().equals(nomePesquisado)){
                            System.out.println(empregado);
                        }
                    });
                    break;
            }
        }while(option != 0);
    }
    public static void limpa(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
