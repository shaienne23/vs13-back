package Classes;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("------------CONTA CORRENTE--------------------------");
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
        System.out.println("Cheque Especial: " + chequeEspecial);
        System.out.println("----------------------------------------------------");
    }

    public boolean sacar(double valorASacar) {
        if (valorASacar <= 0) {
            System.out.println("---------------SAQUE CONTA CORRENTE-------------------");
            System.out.println("Saldo insuficiente para saque");
            return false;
        } else if (valorASacar > saldo + chequeEspecial) {
            System.out.println("---------------SAQUE CONTA CORRENTE-------------------");
            System.out.println("Saldo de conta + cheque especial insuficiente para saque ");
            return false;
        } else {
            saldo -= valorASacar;
            System.out.println("---------------SAQUE CONTA CORRENTE-------------------");
            System.out.println("Saque bem sucedido seu saldo é: " + saldo);

            return true;
        }
    }

    public boolean depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            System.out.println("---------------DEPOSITO CONTA CORRENTE-------------------");
            System.out.println("Valor para deposito invalido, para deposito é necessario valores acima de 0.");
            return false;
        } else {
            saldo += valorDeposito;
            System.out.println("---------------DEPOSITO CONTA CORRENTE-------------------");
            System.out.println("Deposito bem sucedido seu saldo é: " + saldo);
            return true;
        }
    }
    public double retornarSaldo() {
        double saldoTotal = saldo + chequeEspecial;
        System.out.println("---------------SALDO CONTA CORRENTE-------------------");
        System.out.println("O saldo somado ao cheque especial é:" + saldoTotal );
        return saldoTotal;
    }

    public boolean transferir(ContaCorrente outraConta, double valor) {
        if (valor <= 0) {
            System.out.println("---------------TRANSFERENCIA ENTRE CONTAS-------------------");
            System.out.println("Valor inválido para transferência, é necessario valores acima de 0.\n");
            return false;
        } else if (valor > saldo + chequeEspecial) {
            System.out.println("---------------TRANSFERENCIA ENTRE CONTAS-------------------");
            System.out.println("Saldo insuficiente para transferência.");
            return false;
        } else {
            this.sacar(valor);
            outraConta.depositar(valor);
            System.out.println("---------------TRANSFERENCIA ENTRE CONTAS-------------------");
            System.out.println("Transferência bem-sucedida.");
            return true;
        }
    }
}