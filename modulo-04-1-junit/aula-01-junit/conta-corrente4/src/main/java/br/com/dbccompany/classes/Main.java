package br.com.dbccompany.classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Contato contatoPessoa1 = new Contato();
        contatoPessoa1.setDescricao("Shaienne Oliveira dos Santos");
        contatoPessoa1.setTipo(1);
        contatoPessoa1.setTelefone("99727-9376");

        Contato contatoPessoa2 = new Contato();
        contatoPessoa2.setDescricao("Daniel de Oliveira Santos");
        contatoPessoa2.setTipo(2);
        contatoPessoa2.setTelefone("99990-3122");

        Contato contatoPessoa3 = new Contato();
        contatoPessoa3.setDescricao("James De Oliveira Santos");
        contatoPessoa3.setTipo(1);
        contatoPessoa3.setTelefone("99876-1223");

        Endereco endereco1 = new Endereco();
        endereco1.setEstado("ES");
        endereco1.setCidade("Serra");
        endereco1.setNumero(107);
        endereco1.setLogradouro("Av. Sao Paulo");
        endereco1.setPais("Brasil");
        endereco1.setCep("29175573");
        endereco1.setTipo(1);
        endereco1.setComplemento("Prox pracinha guarany");

        Endereco endereco2 = new Endereco();
        endereco2.setEstado("ES");
        endereco2.setCidade("Serra");
        endereco2.setNumero(103);
        endereco2.setLogradouro("Rua das Estrelas");
        endereco2.setPais("Brasil");
        endereco2.setCep("29162-673");
        endereco2.setTipo(2);
        endereco2.setComplemento("Prox mercado ServeBem");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Shaienne Oliveira dos Santos");
        cliente1.setCpf("12309834589");
        cliente1.setEnderecos(new ArrayList<>(List.of(endereco1, endereco2)));
        cliente1.setContatos(new ArrayList<>(List.of(contatoPessoa1, contatoPessoa3)));

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Daniel de Oliveira Santos");
        cliente2.setCpf("01234567890");
        cliente2.setEnderecos(new ArrayList<>(List.of(endereco1)));
        cliente2.setContatos(new ArrayList<>(List.of(contatoPessoa1, contatoPessoa2)));

        Cliente cliente = new Cliente();
        ContaPoupanca contaPoupanca = new ContaPoupanca("123456", "001", 1000.0, cliente);


        ContaCorrente conta1 = new ContaCorrente(cliente1, 400);
        conta1.setNumeroConta("1234");
        conta1.setAgencia("52");
        conta1.setSaldo(10000);

        ContaCorrente conta2 = new ContaCorrente(cliente2, 500);
        conta2.setNumeroConta("7801");
        conta2.setAgencia("66");
        conta2.setSaldo(8008);

        ContaPagamento contaPagamento1 = new ContaPagamento(cliente1, 1000);
        contaPagamento1.setNumeroConta("5678");
        contaPagamento1.setAgencia("99");
        contaPagamento1.setSaldo(2000);

        ContaPoupanca contaPoupanca2 = new ContaPoupanca("123456", "001", 1000.0, cliente1);
        contaPoupanca2.setCliente(cliente2);

        conta1.transferir(contaPagamento1, 1000);
        contaPagamento1.sacar(50);
        contaPoupanca2.creditarTaxa();

        conta2.sacar(20000);
        conta1.depositar(2000);

        conta1.retornarSaldo();
        conta2.retornarSaldo();

        conta1.transferir(conta2, 500.0);
        contaPoupanca2.transferir(conta1, 300);

        System.out.println("---------------INFORMAÇÕES CONTA CORRENTE-------------------");
        conta1.imprimirContaCorrente();
        conta2.imprimirContaCorrente();

        System.out.println("\n---------------INFORMAÇÕES CONTA PAGAMENTO-------------------");
        contaPagamento1.imprimirInterface();

        System.out.println("\n=== Dados da Conta Poupança 2 ===");
        contaPoupanca2.imprimirInterface();
    }
}
