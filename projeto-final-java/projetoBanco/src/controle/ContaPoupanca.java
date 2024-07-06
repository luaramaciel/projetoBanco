package controle;

import modelo.Cliente;

public class ContaPoupanca extends Conta {
    private static final double TAXA_JUROS = 0.05;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    public void calcularJuros() {
        double juros = getSaldo() * TAXA_JUROS;
        depositar(juros);
        System.out.println("Juros de R$ " + juros + " creditados na conta.");
    }
}
