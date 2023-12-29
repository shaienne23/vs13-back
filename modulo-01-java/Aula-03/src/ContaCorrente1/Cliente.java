package ContaCorrente1;

public class Cliente {
    public String nome;
    public Endereco[] enderecos = new Endereco[2];
    public Contato[] contatos = new Contato[2];
    public String cpf;

    public static void main(String[] args) {
        Cliente primeiroCliente = new Cliente();
        primeiroCliente.nome = "Rodrigo";
        primeiroCliente.enderecos[0] = primeiroEndereco;
        primeiroCliente.enderecos[1] = segundoEndereco;
        primeiroCliente.contatos[0] = primeiraPessoa;
        primeiroCliente.contatos[1] = terceiraPessoa;
        primeiroCliente.cpf = "12309834589";

        Cliente segundoCliente = new Cliente();
        segundoCliente.nome = "Barbara";
        segundoCliente.enderecos[0] = primeiroEndereco;
        segundoCliente.contatos[0] = primeiraPessoa;
        segundoCliente.contatos[1] = segundaPessoa;
        segundoCliente.cpf = "01234567890";
    }
}
