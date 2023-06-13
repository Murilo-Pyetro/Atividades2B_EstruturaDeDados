/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.exercicio1recursividade;

/**
 *
 * @author muril
 */
public class Exercicio1Recursividade {

    public static void main(String[] args) {
         int resultado = somar(0, 50);
        System.out.println("A soma de 0 a 50 é: " + resultado);
    }

    public static int somar(int inicio, int fim) {
        if (inicio == fim) {
            return fim;
        } else {
            return inicio + somar(inicio + 1, fim);
        }
    }
}
