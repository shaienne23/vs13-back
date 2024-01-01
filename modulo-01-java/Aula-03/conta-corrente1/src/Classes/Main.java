package Classes;

public class Main {
    public static void main(String[] args) {
        Contato contatoPessoa1 = new Contato();
        contatoPessoa1.descricao = "Shaienne Oliveira dos Santos";
        contatoPessoa1.tipo = 1;
        contatoPessoa1.telefone = "99727-9376";

        Contato contatoPessoa2 = new Contato();
        contatoPessoa2.descricao = "Daniel de Oliveira Santos";
        contatoPessoa2.tipo = 2;
        contatoPessoa2.telefone = "99990-3122";

        Contato contatoPessoa3 = new Contato();
        contatoPessoa3.descricao = "James De Oliveira Santos";
        contatoPessoa3.tipo = 1;
        contatoPessoa3.telefone = "99876-1223";

        Endereco endereco1 = new Endereco();
        endereco1.estado = "ES";
        endereco1.cidade = "Serra";
        endereco1.numero = 107;
        endereco1.logradouro = "Av. Sao Paulo";
        endereco1.pais = "Brasil";
        endereco1.cep = "29175573";
        endereco1.tipo = 1;
        endereco1.complemento = "Prox pracinha guarany";

        Endereco endereco2 = new Endereco();
        endereco2.estado = "ES";
        endereco2.cidade = "Serra";
        endereco2.numero = 103;
        endereco2.logradouro = "Rua das Estrelas";
        endereco2.pais = "Brasil";
        endereco2.cep = "29162-673";
        endereco2.tipo = 2;
        endereco2.complemento = "prox mercado serveBem";

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Shaienne Oliveira dos Santos";
        cliente1.enderecos[0] = endereco1;
        cliente1.enderecos[1] = endereco2;
        cliente1.contatos[0] = contatoPessoa1;
        cliente1.contatos[1] = contatoPessoa3;
        cliente1.cpf = "12309834589";

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Daniel de Oliveira Santos";
        cliente2.enderecos[0] = endereco1;
        cliente2.contatos[0] = contatoPessoa1;
        cliente2.contatos[1] = contatoPessoa2;
        cliente2.cpf = "01234567890";

        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.cliente = cliente1;
        contaCorrente1.numeroConta = "1234";
        contaCorrente1.agencia = 52;
        contaCorrente1.saldo = 10000;
        contaCorrente1.chequeEspecial = 400;

        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.cliente = cliente2;
        contaCorrente2.numeroConta = "7801";
        contaCorrente2.agencia = 66;
        contaCorrente2.saldo = 8008;
        contaCorrente2.chequeEspecial = 500;

        contaCorrente2.sacar( 20000);
        contaCorrente1.depositar( -2000);

        contaCorrente1.retornarSaldo();
        contaCorrente2.retornarSaldo();

        contaCorrente1.transferir(contaCorrente2, 500.0);

        contaCorrente1.imprimirContaCorrente();
        contaCorrente2.imprimirContaCorrente();

}}
