/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.unipar.exercicio1pesqlb;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author muril
 */
public class Exercicio1PesqLB {

    public static void main(String[] args) {
 
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de números a serem cadastrados: "));
            int[] numeros = new int[quantidade];

            for (int i = 0; i < quantidade; i++) {
                numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ": "));
            }

            Arrays.sort(numeros); // Coloca os números em ordem crescente

            String menu = "Menu de Pesquisa\n"
                    + "1. Pesquisa Linear\n"
                    + "2. Pesquisa Binária";
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu + "\nEscolha o tipo de pesquisa (1 ou 2): "));

            int numeroPesquisado = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser pesquisado: "));

            int indice;

            if (opcao == 1) {
                indice = pesquisaLinear(numeros, numeroPesquisado);
            } else if (opcao == 2) {
                indice = pesquisaBinaria(numeros, numeroPesquisado);
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. O programa será encerrado.");
                return;
            }

            if (indice == -1) {
                JOptionPane.showMessageDialog(null, "O número não foi encontrado.");
            } else {
                JOptionPane.showMessageDialog(null, "O número foi encontrado na posição " + (indice + 1) + ".");
            }
        }

        public static int pesquisaLinear(int[] array, int numero) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == numero) {
                    return i;
                }
            }
            return -1; // Número não encontrado
        }

        public static int pesquisaBinaria(int[] array, int numero) {
            int esquerda = 0;
            int direita = array.length - 1;

            while (esquerda <= direita) {
                int meio = (esquerda + direita) / 2;

                if (array[meio] == numero) {
                    return meio;
                } else if (array[meio] < numero) {
                    esquerda = meio + 1;
                } else {
                    direita = meio - 1;
                }
            }

            return -1; // Número não encontrado
        }
    }
