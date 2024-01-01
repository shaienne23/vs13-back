package Classes;

import Interfaces.MovimentacaoInterface;

public class Conta implements MovimentacaoInterface {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta() {

    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta){
        this.numeroConta= numeroConta;
    }
    public String getAgencia(){
        return agencia;
    }
    public void setAgencia(String agencia){
        this.agencia = agencia;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        return false;
    }
    public boolean depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            System.out.println("---------------DEPOSITO CONTA CORRENTE-------------------");
            System.out.println("Valor para deposito invalido, para deposito é necessario valores acima de 0.");
            System.out.println("----------------------------------------------------");
            return false;
        } else {
            saldo += valorDeposito;
            System.out.println("---------------DEPOSITO CONTA CORRENTE-------------------");
            System.out.println("Deposito bem sucedido seu saldo é: " + saldo);
            System.out.println("----------------------------------------------------");
            return true;
        }
    }
    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor <= 0) {
            System.out.println("---------------TRANSFERENCIA ENTRE CONTAS-------------------");
            System.out.println("Valor inválido para transferência, é necessario valores acima de 0.");
            System.out.println("----------------------------------------------------");
            return false;
        } else if (valor > saldo + destino.getSaldo()) {
            System.out.println("---------------TRANSFERENCIA ENTRE CONTAS-------------------");
            System.out.println("Saldo insuficiente para transferência.");
            System.out.println("----------------------------------------------------");
            return false;
        } else {
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println("---------------TRANSFERENCIA ENTRE CONTAS-------------------");
            System.out.println("Transferência bem-sucedida.");
            System.out.println("----------------------------------------------------");
            return true;
        }
    }
}
