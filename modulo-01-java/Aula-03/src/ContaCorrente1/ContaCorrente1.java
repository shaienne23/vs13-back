package ContaCorrente1;

public class ContaCorrente1 {
    private String clienteNome;
    private String clienteCpf;
    private String primeiroEndereco;
    private String segundoEndereco;
    private String primeiraPessoa;
    private String terceiraPessoa;

     private double saldoConta;
    private double chequeEspecialFixo;

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }

        double valorTotal = saldoConta + chequeEspecialFixo;

        if (valorTotal < valor) {
            System.out.println("Saque não permitido. Saldo insuficiente.");
            return false;
        }

        saldoConta -= valor;
        System.out.println(clienteNome + " sacou R$" + valor);
        return true;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }

        saldoConta += valor;
        System.out.println(clienteNome + " depositou R$" + valor);
    }

    public boolean transferir(ContaCorrente1 destino, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return false;
        }

        double valorTotal = saldoConta + chequeEspecialFixo;

        if (valorTotal < valor) {
            System.out.println("Transferência não permitida. Saldo insuficiente.");
            return false;
        }

        saldoConta -= valor;
        destino.depositar(valor);

        System.out.println(clienteNome + " transferiu R$" + valor + " para " + destino.clienteNome);
        return true;
    }
}
