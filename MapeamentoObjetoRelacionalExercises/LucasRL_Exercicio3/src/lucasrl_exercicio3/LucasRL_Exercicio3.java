/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasrl_exercicio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lucaxrl
 */
public class LucasRL_Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String,Integer> agenda = new HashMap<>();
        Scanner leitor = new Scanner (System.in);
        int option = 0;
        do{
            System.out.println("1: Cadastrar Contato.");
            System.out.println("2: Procurar Contato por nome.");
            System.out.println("0: Sair.");
            option = leitor.nextInt();
            switch (option) {
                case 1:
                    limpa();
                    System.out.println("Digite o número do contato:\n");
                    int numero = leitor.nextInt();
                    System.out.println("Digite o Nome do contato:\n");
                    String nome = leitor.next();
                    agenda.put(nome,numero);
                    break;
                case 2:
                    limpa();
                    System.out.println("Digite o nome do contato:\n");
                    String nomeContato = leitor.next();
                    System.out.println(agenda.get(nomeContato));
                    break;
            }
        }while(option!=0);
    }
        public static void limpa(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
}
