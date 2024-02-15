package br.com.dbccompany.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ContaTest {
@Test
@DisplayName("Verificar saldo")
void testarSaqueContaCorrenteEVerificarSaldoComSucesso(){

}
    @Test
    void testarSaqueContaCorrenteSemSaldo(){

    } //não dar certo o valor do saque (saque > saldo + ce)
    @Test
    void testarSaqueContaPoupancaEVerificarSaldoComSucesso(){

    } //deve creditar taxa antes
    @Test
    void testarSaqueContaPoupancaSemSaldo(){

    }//não dar certo o valor do saque (saque > saldo)
    @Test
    void testarSaqueContaPagamentoEVerificarSaldoComSucesso(){

    }
    @Test
    void testarSaqueContaPagamentoSemSaldo(){

    } //não dar certo o valor do saque (saque > saldo)
    @Test
    void testarTransferenciaEVerificarSaldoComSucesso(){

    }
    @Test
    void testarTransferenciaSemSaldo(){

    } //não dar certo o valor do saque (saque > saldo)
    @Test
    void testarDepositoEVerificarSaldoComSucesso(){

    }
    @Test
    void testarDepositoNegativo(){

    }
}