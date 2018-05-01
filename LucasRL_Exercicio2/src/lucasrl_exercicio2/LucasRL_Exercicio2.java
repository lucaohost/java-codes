/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasrl_exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucaxrl
 */
public class LucasRL_Exercicio2 {
    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<>();
        Scanner leitor = new Scanner (System.in);
        int option = 0;
        do{
            System.out.println("1: Cadastrar Carro.");
            System.out.println("2: Listar Carros.");
            System.out.println("3: Pesquisar por cor.");
            System.out.println("4: Pesquisar por modelo.");
            System.out.println("0: Sair.");
            option = leitor.nextInt();
            switch (option) {
                case 1:
                    limpa();
                    System.out.println("Digite a potencia do Motor do Carro:\n");
                    int potencia = leitor.nextInt();
                    System.out.println("Digite a tipo do Motor do Carro:\n");
                    String tipo = leitor.next();
                    Motor motor = new Motor(potencia,tipo);
                    System.out.println("Digite a cor do carro:\n");
                    String cor =  leitor.next();
                    System.out.println("Digite o modelo do carro:\n");
                    String modelo = leitor.next();
                    System.out.println("Digite a velocidade atual do carro:\n");
                    double velocidadeAtual = leitor.nextDouble();
                    System.out.println("Digite a velocidade máxima do carro:\n");
                    double velocidadeMaxima = leitor.nextDouble();
                    Carro car = new Carro(cor,modelo,velocidadeAtual,velocidadeMaxima,motor);
                    carros.add(car);
                    break;
                case 2:
                    limpa();
                    carros.forEach((carro) -> {
                        System.out.println("\n");
                        System.out.println(carro);
                    });
                    break;
                case 3:
                    limpa();
                    System.out.println("Digite a cor do carro:\n");
                    String corPesquisada = leitor.next();
                    carros.forEach((carro) -> {
                        if(carro.getCor().equals(corPesquisada)){
                            System.out.println(carro);
                        }
                    });
                    break;
                case 4:
                    limpa();
                    System.out.println("Digite o modelo do carro:\n");
                    String modeloPesquisado = leitor.next();
                    carros.forEach((carro) -> {
                        if(carro.getModelo().equals(modeloPesquisado)){
                            System.out.println(carro);
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
