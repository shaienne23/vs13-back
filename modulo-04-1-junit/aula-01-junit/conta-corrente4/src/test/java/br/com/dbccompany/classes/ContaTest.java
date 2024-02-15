package br.com.dbccompany.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ContaTest {
@Test
@DisplayName("Deveria Sacar e Verificar saldo da conta Corrente")
    void testarSaqueContaCorrenteEVerificarSaldoComSucesso() {
    Cliente cliente2 = new Cliente();
    ContaCorrente conta2 = new ContaCorrente(cliente2, 500);
    conta2.setNumeroConta("7801");
    conta2.setAgencia("66");
    conta2.setSaldo(8000);
    conta2.sacar(2000);

    double saldoAtualizado = 6000;
    double saldo = conta2.getSaldo();

    Assertions.assertEquals(saldoAtualizado, saldo);
}
    @Test
    @DisplayName("Deveria Testar Saque na Conta Corrente.")//não dar certo o valor do saque (saque > saldo + ce)
    void testarSaqueContaCorrenteSemSaldo() {
        Cliente cliente3 = new Cliente();
        ContaCorrente conta3 = new ContaCorrente(cliente3, 500);
        conta3.setNumeroConta("7802");
        conta3.setAgencia("67");
        conta3.setSaldo(3500);

        boolean saqueRealizado = conta3.sacar(9000);
        Assertions.assertFalse(saqueRealizado);
    }
    @Test
    @DisplayName("Deveria Testar Saque  e verificar saldo na conta poupança.")//deve creditar taxa antes
    void testarSaqueContaPoupancaEVerificarSaldoComSucesso(){
        Cliente cliente = new Cliente();
        ContaPoupanca contaPoupanca = new ContaPoupanca(
            "123456", "001", 1000.0, cliente);
        contaPoupanca.creditarTaxa();
        double saldoInicial = contaPoupanca.getSaldo();

        boolean saque = contaPoupanca.sacar(600);
        Assertions.assertTrue(saque);

        double novoSaldoEsperado = saldoInicial  - 600.0;
        double saldoAtual = contaPoupanca.getSaldo();

        Assertions.assertEquals(novoSaldoEsperado, saldoAtual);
    }
    @Test
    @DisplayName("Deveria Testar Saque na Conta Poupança.")//não dar certo o valor do saque (saque > saldo)
    void testarSaqueContaPoupancaSemSaldo(){
        Cliente cliente = new Cliente();
        ContaPoupanca contaPoupanca = new ContaPoupanca(
                "123456", "001", 1000.0, cliente);
        contaPoupanca.creditarTaxa();
        double saldoInicial = contaPoupanca.getSaldo();

        boolean saque = contaPoupanca.sacar(6000);
        Assertions.assertFalse(saque);
    }
    @Test
    @DisplayName("Deveria Testar Saque e verificar saldo na Contade pagamento.")
    void testarSaqueContaPagamentoEVerificarSaldoComSucesso(){

    }
    @Test
    @DisplayName("Deveria Testar Saque na Conta de Pagamento.") //não dar certo o valor do saque (saque > saldo)
    void testarSaqueContaPagamentoSemSaldo(){

    }
    @Test
    @DisplayName("Deveria Testar Transferencia e verificar saldo na Conta Corrente.")
    void testarTransferenciaEVerificarSaldoComSucesso(){

    }
    @Test
    @DisplayName("Deveria Testar transferencia em Conta Corrente sem saldo.")//não dar certo o valor do saque (saque > saldo)
    void testarTransferenciaSemSaldo(){

    }
    @Test
    @DisplayName("Deveria Testar Deposito e verificar saldo na Conta Corrente.")
    void testarDepositoEVerificarSaldoComSucesso(){

    }
    @Test
    @DisplayName("Deveria Testar Deposito negativo na Conta Corrente.")
    void testarDepositoNegativo(){

    }
}