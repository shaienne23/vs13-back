package Classes;
import Interfaces.ImpressaoInterface;

public class ContaPoupanca extends Conta implements ImpressaoInterface{
    private static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(String numeroConta, String agencia, double saldoInicial) {
        super();
    }

    public void creditarTaxa() {
        double novoSaldo = getSaldo() * JUROS_MENSAL;
        setSaldo(novoSaldo);
    }

    public void imprimir() {
        System.out.println("---------------SALDO CONTA POUPANÇA-------------------");
        System.out.println("Saldo: " + getSaldo());
        System.out.println("----------------------------------------------------");
    }

    @Override
    public boolean sacar(double valor) {
        return false;
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        return false;
    }
}
