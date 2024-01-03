package classes;

import interfaces.ImpressaoInterface;

public class ContaPagamento extends Conta implements ImpressaoInterface {
    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, int i) {
        super(cliente);
    }

    private double calcularTaxaSaque() {
        return TAXA_SAQUE;
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotalSaque = valor + calcularTaxaSaque();

        if (valor > 0 && getSaldo() >= valorTotalSaque) {
            super.sacar(valorTotalSaque);
            System.out.println("--------------SAQUE CONTA PAGAMENTO--------------");
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Taxa de saque: R$" + calcularTaxaSaque());
            System.out.println("----------------------------------------------------");
            return true;
        } else {
            System.out.println("----------------------SAQUE CONTA PAGAMENTO----------------------");
            System.out.println("Saldo insuficiente para o saque de R$" + valor);
            System.out.println("----------------------------------------------------");
            return false;
        }
    }

    @Override
    public void imprimirInterface() {
        System.out.println("Cliente: " + getCliente().getNome());
        System.out.println("Saldo: R$" + getSaldo());
    }

}
