package classes;

import interfaces.ImpressaoInterface;

public class ContaPoupanca extends Conta implements ImpressaoInterface {
    private static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(String numeroConta, String agencia, double saldoInicial, Cliente cliente) {
        super(cliente);
        setNumeroConta(numeroConta);
        setAgencia(agencia);
        setSaldo(saldoInicial);
    }

    public void creditarTaxa() {
        double novoSaldo = getSaldo() * JUROS_MENSAL;
        setSaldo(novoSaldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && getSaldo() - valor >= 0) {
            super.sacar(valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para o saque de R$" + valor);
            return false;
        }
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && getSaldo() - valor >= 0) {
            super.transferir(destino, valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para a transferência de R$" + valor);
            return false;
        }
    }

    @Override
    public void imprimirInterface() {
        System.out.println("------------ Conta Poupança ----------");
        System.out.println("Nome do Cliente: " +getCliente().getNome());
        System.out.println("Número da Conta: " + getNumeroConta());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Saldo: " + getSaldo());
        }

}
