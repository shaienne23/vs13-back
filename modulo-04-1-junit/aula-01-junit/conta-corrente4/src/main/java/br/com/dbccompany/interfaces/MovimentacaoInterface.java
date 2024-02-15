package br.com.dbccompany.interfaces;

import br.com.dbccompany.classes.Conta;

public interface MovimentacaoInterface {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta destino, double valor);

    void imprimirInterface();
}

