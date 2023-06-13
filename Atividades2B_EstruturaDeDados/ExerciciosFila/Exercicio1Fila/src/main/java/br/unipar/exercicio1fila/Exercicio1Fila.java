/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.exercicio1fila;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author muril
 */
public class Exercicio1Fila {

    public static void main(String[] args) {
        Queue<String> filaPacientes = new LinkedList<>();

        int opcao = 0;
        while (opcao != 3) {
            String menu = "Menu:\n"
                    + "1 - Adicionar paciente\n"
                    + "2 - Chamar próximo paciente\n"
                    + "3 - Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu + "\n\nEscolha uma opção:"));

            switch (opcao) {
                case 1:
                    String nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente:");
                    adicionarPaciente(filaPacientes, nomePaciente);
                    break;
                case 2:
                    chamarProximoPaciente(filaPacientes);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    private static void adicionarPaciente(Queue<String> filaPacientes, String nomePaciente) {
        if (filaPacientes.size() >= 20) {
            JOptionPane.showMessageDialog(null, "A fila está cheia! Não é possível adicionar mais pacientes.");
        } else {
            filaPacientes.offer(nomePaciente);
            JOptionPane.showMessageDialog(null, "Paciente " + nomePaciente + " adicionado à fila.");
        }
    }

    private static void chamarProximoPaciente(Queue<String> filaPacientes) {
        if (filaPacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia! Não há pacientes para chamar.");
        } else {
            String proximoPaciente = filaPacientes.poll();
            JOptionPane.showMessageDialog(null, "Próximo paciente: " + proximoPaciente);
        }
    }
}
