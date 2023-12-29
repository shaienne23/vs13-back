package ContaCorrente1;


public class ContaCorrente {
        public Cliente cliente;
        public String numeroConta;
        public int agencia;
        public double saldoConta;
        public double chequeEspecialFixo;

    public static void main(String[] args) {

        ContaCorrente primeiraContaCor = new ContaCorrente();
        primeiraContaCor.cliente = primeiroCliente;
        primeiraContaCor.numeroConta = "1234";
        primeiraContaCor.agencia = 52;
        primeiraContaCor.saldoConta = 10000;
        primeiraContaCor.chequeEspecialFixo = 400;

        ContaCorrente segundaContaCor = new ContaCorrente();
        segundaContaCor.cliente = segundoCliente;
        segundaContaCor.numeroConta = "7801";
        segundaContaCor.agencia = 66;
        segundaContaCor.saldoConta = 8000;
        segundaContaCor.chequeEspecialFixo = 1000;

        segundaContaCor.transferir(primeiraContaCor, 200);

        primeiraContaCor.imprimirContaCorrente();
        segundaContaCor.imprimirContaCorrente();

    }
}
