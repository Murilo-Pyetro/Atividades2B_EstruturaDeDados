/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.exercicio2pesqlb;


import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author muril
 */
public class Exercicio2PesqLB {

    public static void main(String[] args) {
         int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de clientes a serem cadastrados:"));

        int[] codigos = new int[quantidade];
        String[] nomes = new String[quantidade];
        String[] datasNascimento = new String[quantidade];
        String[] cpfs = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            codigos[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente " + (i + 1) + ":"));
            nomes[i] = JOptionPane.showInputDialog("Digite o nome do cliente " + (i + 1) + ":");
            datasNascimento[i] = JOptionPane.showInputDialog("Digite a data de nascimento do cliente " + (i + 1) + ":");
            cpfs[i] = JOptionPane.showInputDialog("Digite o CPF do cliente " + (i + 1) + ":");
        }

        ordenarClientes(codigos, nomes, datasNascimento, cpfs);

        int codigoPesquisado = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente a ser pesquisado:"));

        int indice = Arrays.binarySearch(codigos, codigoPesquisado);

        if (indice < 0) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" +
                    "Código: " + codigos[indice] + "\n" +
                    "Nome: " + nomes[indice] + "\n" +
                    "Data de Nascimento: " + datasNascimento[indice] + "\n" +
                    "CPF: " + cpfs[indice]);
        }
    }

    public static void ordenarClientes(int[] codigos, String[] nomes, String[] datasNascimento, String[] cpfs) {
        for (int i = 0; i < codigos.length - 1; i++) {
            for (int j = 0; j < codigos.length - i - 1; j++) {
                if (codigos[j] > codigos[j + 1]) {
                    // Troca os elementos
                    int tempCodigo = codigos[j];
                    String tempNome = nomes[j];
                    String tempDataNascimento = datasNascimento[j];
                    String tempCpf = cpfs[j];

                    codigos[j] = codigos[j + 1];
                    nomes[j] = nomes[j + 1];
                    datasNascimento[j] = datasNascimento[j + 1];
                    cpfs[j] = cpfs[j + 1];

                    codigos[j + 1] = tempCodigo;
                    nomes[j + 1] = tempNome;
                    datasNascimento[j + 1] = tempDataNascimento;
                    cpfs[j + 1] = tempCpf;
                }
            }
        }
    }
}
