package br.com.dbccompany.classes;
import br.com.dbccompany.interfaces.ImpressaoInterface;

public class ContaCorrente extends Conta implements ImpressaoInterface {
    private double chequeEspecial;
    private Cliente cliente;

    public ContaCorrente(Cliente cliente, double chequeEspecial) {
        super();
        this.cliente = cliente;
        this.chequeEspecial = chequeEspecial;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setChequeEspecial(double chequeEspecial){
        this.chequeEspecial=chequeEspecial;
    }
    public double getChequeEspecial() {
        return chequeEspecial;
    }
    public double retornarSaldo() {
        double saldoTotal = super.getSaldo() + chequeEspecial;
        return saldoTotal;
    }
    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido. O valor deve ser maior que zero.");
            return false;
        }
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de " + valor + " realizado com sucesso. Novo saldo: " + getSaldo());
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
    }
    public boolean transferir(Conta destino, double valor) {
        return false;
    }
    @Override
    public void imprimirInterface() {
            System.out.println("---------------SALDO CONTA CORRENTE-------------------");
            double saldoTotal = retornarSaldo();
            System.out.println("O saldo somado ao cheque especial é:" + saldoTotal );
            System.out.println("----------------------------------------------------");
        }
        public void imprimirContaCorrente() {
        if (cliente != null) {
            System.out.println("Nome do Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Número da Conta: " + getNumeroConta());
            System.out.println("Agência: " + getAgencia());
            System.out.println("Saldo: " + getSaldo());
            System.out.println("Cheque Especial: " + getChequeEspecial());
            }
            System.out.println("----------------------------------------------------");
        }
    }



