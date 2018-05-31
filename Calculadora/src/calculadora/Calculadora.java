/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;

/**
 *
 * @author lucaxrl
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cria arraylist para receber número e operadores
        ArrayList<String> calculo = new ArrayList<>();
        //define os operadores
        ArrayList<Character> operadores = new ArrayList<>();
        operadores.add('+');
        operadores.add('-');
        operadores.add('/');
        operadores.add('*');
        
        
        String calculoString = "+11+22-33+44*55*66-99-66/2+45-12";

        //seprara numero e operadores
        String numero = "";
        for (int i = 0; i < calculoString.length(); i++) {
            char aux = calculoString.charAt(i);
            //se n for operador, adiciona o caracter na string
            if (!operadores.contains(aux)) {
                numero += Character.toString(aux);
            }
            //quando achar um operador, bota numero acumulado no aux numa casa
            if (operadores.contains(calculoString.charAt(i))) {
                if (!numero.equals("")) {
                    calculo.add(numero);
                }
                //coloca o operador achado na casa seguinte
                calculo.add(Character.toString(calculoString.charAt(i)));
                numero = "";
            }
            //se n houver mais operadores, coloca o último numero na casa
            if (i == calculoString.length() - 1) {
                if (!numero.equals("")) {
                    calculo.add(numero);
                }
                numero = "";
            }
        }

        //faz calculo de todas as multiplicações
        for (int i = 0; i < calculo.size(); i++) {
            if (calculo.get(i).equals("*")) {
                int n1 = Integer.parseInt(calculo.get(i - 1));
                int n2 = Integer.parseInt(calculo.get(i + 1));
                int resultado = n1 * n2;
                calculo.set(i, Integer.toString(resultado));
                //exclui o primeiro termo
                calculo.remove(i - 1);
                //excluir o segundo termo 
                calculo.remove(i);
                //(não é i+1, pq a fila diminui pela exclusão acima)
                //zera para varrer os valores que regrediram de indice
                i = 0;
            }
        }
        //faz calculo divisão
        for (int i = 0; i < calculo.size(); i++) {
            if (calculo.get(i).equals("/")) {
                int n1 = Integer.parseInt(calculo.get(i - 1));
                int n2 = Integer.parseInt(calculo.get(i + 1));
                int resultado = n1 / n2;
                calculo.set(i, Integer.toString(resultado));
                calculo.remove(i - 1);
                calculo.remove(i);
                i = 0;
            }
        }
        //faz calculo adição e subtração
        for (int i = 0; i < calculo.size(); i++) {
            if (calculo.get(i).equals("+")) {
                //remove sinal positivo à direita
                if(i == 0){
                    calculo.remove(i);
                }else{
                int n1 = Integer.parseInt(calculo.get(i - 1));
                int n2 = Integer.parseInt(calculo.get(i + 1));
                int resultado = n1 + n2;
                calculo.set(i, Integer.toString(resultado));
                calculo.remove(i - 1);
                calculo.remove(i);
                //reinicia iterator para buscar mais adições/subtrações
                i = 0;
                }
            }
            if (calculo.get(i).equals("-")) {
                if (i == 0) {
                    calculo.add("-");
                    calculo.add(calculo.get(i + 1));
                    calculo.remove(i);
                    calculo.remove(i);
                    //se for um mais, é excluído pq é indifernte no cálculo
                    if (calculo.get(i).equals("+")) {
                        calculo.remove(i);
                    }
                    i = 0;
                } else {
                    int n1 = Integer.parseInt(calculo.get(i - 1));
                    int n2 = Integer.parseInt(calculo.get(i + 1));
                    int resultado = n1 - n2;
                    calculo.set(i, Integer.toString(resultado));
                    calculo.remove(i - 1);
                    calculo.remove(i);
                    //reinicia iterator para buscar mais adições/subtrações
                    i = 0;
                }
            }
        }
            System.out.println(calculo.get(0));
    }
}
