import controle.Conta;
import controle.ContaCorrente;
import controle.ContaPoupanca;
import modelo.Cliente;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        CriarBanco();
    }

    private static void CriarBanco() {
        JFrame f = new JFrame();
        String nome = JOptionPane.showInputDialog(f, "Entre Nome do Cliente");
        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        Conta cc = new ContaCorrente(cliente);
        Conta pp = new ContaPoupanca(cliente);

        boolean continuar = true;

        while (continuar) {
            int tipoConta = Integer.parseInt(JOptionPane.showInputDialog(f, "Entre com o tipo da conta:\n0 - Sair\n1 - Conta Corrente\n2 - Conta Poupança"));

            switch (tipoConta) {
                case 0:
                    continuar = false; // Sair do loop
                    break;
                case 1:
                    operarContaCorrente(f, (ContaCorrente) cc, (ContaPoupanca) pp);
                    break;
                case 2:
                    operarContaPoupanca(f, (ContaPoupanca) pp, (ContaCorrente) cc);
                    break;
                default:
                    JOptionPane.showMessageDialog(f, "Opção inválida. Tente novamente.");
            }
        }

        JOptionPane.showMessageDialog(f, "Programa encerrado.");
    }

    private static void operarContaCorrente(JFrame f, ContaCorrente cc, ContaPoupanca pp) {
        int movimentoC = Integer.parseInt(JOptionPane.showInputDialog(f, "0 - Voltar\n1 - Saldo\n2 - Sacar\n3 - Deposito\n4 - Transferência para Poupança\n5 - Empréstimo"));

        switch (movimentoC) {
            case 0:
                return; // Voltar ao menu principal
            case 1:
                cc.imprimirExtrato();
                break;
            case 2:
                double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do saque"));
                cc.sacar(valorSaque);
                cc.imprimirExtrato();
                break;
            case 3:
                double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do depósito"));
                cc.depositar(valorDeposito);
                cc.imprimirExtrato();
                break;
            case 4:
                double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da transferência"));
                cc.transferir(valorTransferencia, pp);
                cc.imprimirExtrato();
                break;
            case 5:
                double valorEmprestimo = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do empréstimo"));
                cc.fazerEmprestimo(valorEmprestimo);
                cc.imprimirExtrato();
                break;
            default:
                JOptionPane.showMessageDialog(f, "Opção inválida. Tente novamente.");
        }
    }

    private static void operarContaPoupanca(JFrame f, ContaPoupanca pp, ContaCorrente cc) {
        int movimentoP = Integer.parseInt(JOptionPane.showInputDialog(f, "0 - Voltar\n1 - Saldo\n2 - Sacar\n3 - Deposito\n4 - Transferência para Corrente\n5 - Calcular Juros"));

        switch (movimentoP) {
            case 0:
                return; // Voltar ao menu principal
            case 1:
                pp.imprimirExtrato();
                break;
            case 2:
                double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do saque"));
                pp.sacar(valorSaque);
                pp.imprimirExtrato();
                break;
            case 3:
                double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do depósito"));
                pp.depositar(valorDeposito);
                pp.imprimirExtrato();
                break;
            case 4:
                double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da transferência"));
                pp.transferir(valorTransferencia, cc);
                pp.imprimirExtrato();
                break;
            case 5:
                pp.calcularJuros(); // Certifique-se de que este método está implementado na classe ContaPoupanca
                pp.imprimirExtrato();
                break;
            default:
                JOptionPane.showMessageDialog(f, "Opção inválida. Tente novamente.");
        }
    }
}
