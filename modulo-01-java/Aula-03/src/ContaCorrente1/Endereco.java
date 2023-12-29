package ContaCorrente1;

public class Endereco {
    public String estado;
    public String cidade;
    public int numero;
    public String logradouro;
    public String pais;
    public String cep;
    public int tipo;
    public String complemento;

    public static void main(String[] args) {

        Endereco primeiroEndereco = new Endereco();
        primeiroEndereco.estado = "ES";
        primeiroEndereco.cidade = "Serra";
        primeiroEndereco.numero = 107;
        primeiroEndereco.logradouro = "Av. Sao Paulo";
        primeiroEndereco.pais = "Brasil";
        primeiroEndereco.cep = "29175573";
        primeiroEndereco.tipo = 1;
        primeiroEndereco.complemento = "Prox pracinha guarany";

        Endereco segundoEndereco = new Endereco();
        segundoEndereco.estado = "ES";
        segundoEndereco.cidade = "Serra";
        segundoEndereco.numero = 103;
        segundoEndereco.logradouro = "Rua das Estrelas";
        segundoEndereco.pais = "Brasil";
        segundoEndereco.cep = "29162-673";
        segundoEndereco.tipo = 2;
        segundoEndereco.complemento = "prox mercado serveBem";

    }
}
