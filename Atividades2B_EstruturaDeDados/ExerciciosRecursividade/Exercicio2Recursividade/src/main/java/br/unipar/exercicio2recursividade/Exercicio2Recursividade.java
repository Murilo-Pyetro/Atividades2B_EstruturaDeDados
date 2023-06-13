/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.exercicio2recursividade;


import javax.swing.JOptionPane;

/**
 *
 * @author muril
 */
public class Exercicio2Recursividade {

    public static void main(String[] args) {
         String input = JOptionPane.showInputDialog("Digite um número inteiro que não seja negativo:");
        int numero = Integer.parseInt(input);

        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "Número inválido. O número não pode ser negativo.");
        } else {
            long fatorial = calcularFatorial(numero);
            JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é: " + fatorial);
        }
    }

    public static long calcularFatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
}
