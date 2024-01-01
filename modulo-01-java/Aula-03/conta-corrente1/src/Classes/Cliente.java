package Classes;

public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos;
    public Endereco[] enderecos;

    public Cliente() {
        contatos = new Contato[2];
        enderecos = new Endereco[2];
    }
    public void imprimirContatos() {
        for (Contato contato : contatos) {
            contato.imprimirContato();
        }
    }
    public void imprimirEnderecos() {
        for (Endereco endereco : enderecos) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        imprimirContatos();
        imprimirEnderecos();
    }}