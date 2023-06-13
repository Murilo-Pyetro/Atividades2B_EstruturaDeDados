/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.exercicio3recurisividade;


import javax.swing.JOptionPane;

/**
 *
 * @author muril
 */
public class Exercicio3Recurisividade {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número inteiro positivo:");
        int numero = Integer.parseInt(input);

        String fibonacciSequence = "Sequência Fibonacci até " + numero + ":\n";

        for (int i = 0; i <= numero; i++) {
            fibonacciSequence += calcularFibonacci(i) + " ";
        }

        JOptionPane.showMessageDialog(null, fibonacciSequence);
    }

    public static int calcularFibonacci(int numero) {
        if (numero == 0) {
            return 0;
        } else if (numero == 1) {
            return 1;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }
}
