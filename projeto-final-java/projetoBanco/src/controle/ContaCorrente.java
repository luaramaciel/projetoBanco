package controle;

import modelo.Cliente;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    public void fazerEmprestimo(double valorEmprestimo) {
        depositar(valorEmprestimo);
        System.out.println("Empréstimo de R$ " + valorEmprestimo + " realizado com sucesso.");
    }
}
