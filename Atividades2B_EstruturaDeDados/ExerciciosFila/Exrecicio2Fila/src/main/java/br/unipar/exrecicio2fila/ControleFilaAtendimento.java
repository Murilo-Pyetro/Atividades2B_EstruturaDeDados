/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.exrecicio2fila;

/**
 *
 * @author muril
 */
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

    class Cliente {
    int senha;
    String nome;
    int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }
}

public class ControleFilaAtendimento {
    private Queue<Cliente> filaPrioritaria = new LinkedList<>();
    private Queue<Cliente> filaNormal = new LinkedList<>();
    private int contadorPrioritariosAtendidos = 0;

    public void adicionarCliente() {
        String input = JOptionPane.showInputDialog("Digite o número da senha:");
        int senha = Integer.parseInt(input);

        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");

        input = JOptionPane.showInputDialog("Digite o ano de nascimento do cliente:");
        int anoNascimento = Integer.parseInt(input);

        Cliente cliente = new Cliente(senha, nome, anoNascimento);

        if (cliente.anoNascimento <= 1956) {  // 65 anos ou mais
            filaPrioritaria.offer(cliente);
        } else {
            filaNormal.offer(cliente);
        }
    }

    public void chamarCliente() {
        if (contadorPrioritariosAtendidos < 2 && !filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.poll();
            contadorPrioritariosAtendidos++;

            String mensagem = "Cliente chamado:\n" +
                    "Senha: " + cliente.senha + "\n" +
                    "Nome: " + cliente.nome + "\n" +
                    "Ano de nascimento: " + cliente.anoNascimento;

            JOptionPane.showMessageDialog(null, mensagem);
        } else if (!filaNormal.isEmpty()) {
            Cliente cliente = filaNormal.poll();
            contadorPrioritariosAtendidos = 0;

            String mensagem = "Cliente chamado:\n" +
                    "Senha: " + cliente.senha + "\n" +
                    "Nome: " + cliente.nome + "\n" +
                    "Ano de nascimento: " + cliente.anoNascimento;

            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Não há clientes na fila.");
        }
    }

    public static void main(String[] args) {
        ControleFilaAtendimento controleFila = new ControleFilaAtendimento();
        int opcao;

        do {
            String menu = "===== Menu =====\n" +
                    "1. Adicionar cliente\n" +
                    "2. Chamar cliente\n" +
                    "3. Sair";

            String input = JOptionPane.showInputDialog(menu + "\n\nEscolha uma opção:");
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    controleFila.adicionarCliente();
                    break;
                case 2:
                    controleFila.chamarCliente();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }
}

